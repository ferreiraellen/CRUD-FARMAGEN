package com.generation.farmagen.farmagen.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmagen.farmagen.model.Produto;
import com.generation.farmagen.farmagen.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Produto> GetById(@PathVariable Long id){
		 return repository.findById(id)
				 .map(resp -> ResponseEntity.ok(resp))
				 .orElse(ResponseEntity.notFound().build());
}
	 @GetMapping("/nome/{nome}")
	 public ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome){
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	 }
}
