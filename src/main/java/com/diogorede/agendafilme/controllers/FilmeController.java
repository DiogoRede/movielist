package com.diogorede.agendafilme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogorede.agendafilme.models.Filme;
import com.diogorede.agendafilme.services.FilmeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;
    
    @GetMapping()
    List<Filme> findAll() {
        return filmeService.findAll();
    }
    
    @PostMapping
    ResponseEntity<List<Filme>> save(@Valid @RequestBody Filme filme){
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
    }

    @PutMapping
    List<Filme> update(@RequestBody Filme filme){
        return filmeService.update(filme);
    }

    @DeleteMapping("/{id}")
    List<Filme> delete(@PathVariable("id") String id){
        return filmeService.delete(id);
    }

}