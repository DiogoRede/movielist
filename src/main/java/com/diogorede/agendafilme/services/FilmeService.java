package com.diogorede.agendafilme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.diogorede.agendafilme.models.Filme;
import com.diogorede.agendafilme.repositories.FilmeRepository;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> save(Filme filme){
        filmeRepository.save(filme);
        return findAll();
    }

    public List<Filme> findAll(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending().and(
                Sort.by("assistido").ascending()
            )
        );
        return filmeRepository.findAll(sort);
    }

    public List<Filme> update(Filme filme){
        filmeRepository.save(filme);
        return findAll();
    }

    public List<Filme> delete(String id){
        filmeRepository.deleteById(id);
        return findAll();
    }
}