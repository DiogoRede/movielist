package com.diogorede.agendafilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diogorede.agendafilme.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{}