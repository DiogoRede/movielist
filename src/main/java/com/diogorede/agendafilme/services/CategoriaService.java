package com.diogorede.agendafilme.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.diogorede.agendafilme.models.Categoria;
import com.diogorede.agendafilme.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        Sort sort = Sort.by("nome").ascending();
        return categoriaRepository.findAll(sort);
    }

    public List<Categoria> save(Categoria categoria){
        categoriaRepository.save(categoria);
        return findAll();
    }

    public List<Categoria> delete(String id){
        categoriaRepository.deleteById(id);
        return findAll();
    }

    public List<Categoria> update(Categoria categoria){
        categoriaRepository.save(categoria);
        return findAll();
    }

    public Optional<Categoria> findById(String id){
        return categoriaRepository.findById(id);
    }
}