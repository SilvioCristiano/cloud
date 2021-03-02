package com.cloud.backend.resources;



import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloud.backend.domain.Iac;
import com.cloud.backend.dto.IacDTO;
import com.cloud.backend.resources.utils.URL;
import com.cloud.backend.service.IacService;

@RestController
@RequestMapping(value="/iacs")
public class IacResource {

	@Autowired
	private IacService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Iac> find(@PathVariable Integer id) {
		Iac obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<IacDTO>> findPage(
			@RequestParam(value="name", defaultValue="") String name, 
			@RequestParam(value="categorias", defaultValue="") String categorias, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="name") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(name);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Iac> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<IacDTO> listDto = list.map(obj -> new IacDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/inscricao", method=RequestMethod.GET)
	public ResponseEntity<Iac> find(@RequestParam(value="value") String inscricao) {
		Iac obj = service.findByInscricao(inscricao);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Iac> insert(@Valid @RequestBody IacDTO objDTO) {
		Iac obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(url).build();
	}
	//@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value ="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody IacDTO objDTO,@PathVariable Integer id){
		Iac obj = service.fromDTO(objDTO);
		obj.setId(id); 
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	@RequestMapping(value="/picture", method=RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
}
