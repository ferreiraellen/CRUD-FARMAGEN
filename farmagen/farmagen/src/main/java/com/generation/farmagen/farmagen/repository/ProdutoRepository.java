package com.generation.farmagen.farmagen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.generation.farmagen.farmagen.model.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	public List<Produto>findAllByNomeContainingIgnoreCase (String nome);
}


	
 
 
 