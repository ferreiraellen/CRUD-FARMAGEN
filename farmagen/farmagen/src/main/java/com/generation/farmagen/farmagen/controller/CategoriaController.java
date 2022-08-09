package com.generation.farmagen.farmagen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmagen.farmagen.model.Categoria;
import com.generation.farmagen.farmagen.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
 @Autowired
 private CategoriaRepository repository;
 
 @GetMapping
 public ResponseEntity<List<Categoria>> GetAll(){
	 return ResponseEntity.ok(repository.findAll());
	 
 }
 
 @GetMapping("/{id}")
 public ResponseEntity<Categoria> GetById (@PathVariable Long id){
	 return repository.findById(id)
			 .map(resp -> ResponseEntity.ok(resp))
			 .orElse(ResponseEntity.notFound().build());
 }
 @GetMapping("nome/{nome}")
 public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String nome ){
	 return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(nome));
 }
}
