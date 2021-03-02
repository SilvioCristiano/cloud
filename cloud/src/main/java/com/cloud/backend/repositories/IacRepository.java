package com.cloud.backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.backend.domain.Categoria;
import com.cloud.backend.domain.Iac;

@Repository
public interface IacRepository extends JpaRepository<Iac, Integer>{
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Iac obj INNER JOIN obj.categorias cat WHERE obj.name LIKE %:name% AND cat IN :categorias")
	Page<Iac> findDistinctByNameContainingAndCategoriasIn(@Param("name") String name, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

	@Transactional(readOnly=true)
	Iac findByInscricao(String inscricao);
}
