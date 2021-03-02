package com.cloud.backend.service;


import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.backend.domain.Categoria;
import com.cloud.backend.domain.Cliente;
import com.cloud.backend.domain.Iac;
import com.cloud.backend.domain.enums.Perfil;
import com.cloud.backend.dto.IacDTO;
import com.cloud.backend.repositories.CategoriaRepository;
import com.cloud.backend.repositories.IacRepository;
import com.cloud.backend.security.UserSS;
import com.cloud.backend.service.exceptions.AuthorizationException;
import com.cloud.backend.service.exceptions.DataIntegrityException;
import com.cloud.backend.service.exceptions.ObjectNotFoundException;

@Service
public class IacService {
	@Autowired
	private IacRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	

	@Autowired
	private S3Service s3Service;

	@Autowired
	private ImageService imageService;

	@Value("${img.prefix.product.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;
	
	public Iac find(Integer id) {

		Iac obj = repo.findOne(id);
		
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id " + id + " Tipo: " + Iac.class.getName());
		}
		return obj;
	}
	public Iac insert(Iac obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Iac update(Iac obj) {
		Iac newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.delete(id);
		}
		catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui advogados");
		}
	}

	public List<Iac> findAll() {
		return repo.findAll();
	}
	
	public Page<Iac> findPage(Integer page, Integer linePerPage, String orgerBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linePerPage,Direction.valueOf(direction), orgerBy);
		return repo.findAll(pageRequest);
		
	}
	public Page<Iac> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAll(ids);
		return repo.findDistinctByNameContainingAndCategoriasIn(name, categorias, pageRequest);	
	}
	public URI uploadProfilePicture(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);

		String fileName = prefix + user.getId() + ".jpg";

		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}
	
	public Iac fromDTO(IacDTO objDTO) {
		return new Iac(objDTO.getId(), objDTO.getName(),objDTO.getPreco(), 
				objDTO.getInscricao(), objDTO.getSaccional(),objDTO.getEmail(),objDTO.getCpfOuCnpj());
		
	}
	
	private void updateData(Iac newObj, Iac obj) {
		newObj.setName(obj.getName());
		newObj.setPreco(obj.getPreco());
	  //newObj.setCategorias(obj.getCategorias());
		
	}
	
	public Iac findByInscricao(String inscricao) {

	
		Iac obj = repo.findByInscricao(inscricao);
		
		return obj;
	}
}
