package com.diogorede.agendafilme.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diogorede.agendafilme.models.Categoria;
import com.diogorede.agendafilme.services.CategoriaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping()
    List<Categoria> findAll(){
        return service.findAll();
    }

    @PostMapping()
    List<Categoria> save(@RequestBody Categoria categoria) {
        return service.save(categoria);
    }

    @PutMapping()
    List<Categoria> update(@RequestBody Categoria categoria) {
        return service.update(categoria);
    }

    @GetMapping("/id")
    ResponseEntity<Object> findByid(@PathVariable("id") String id) {
        Optional<Categoria> categoriaOptional = service.findById(id);
        if(categoriaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoria não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoriaOptional.get());
    }

    @DeleteMapping("/{id}")
    List<Categoria> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}