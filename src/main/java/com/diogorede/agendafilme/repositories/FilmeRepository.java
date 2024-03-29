package com.diogorede.agendafilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diogorede.agendafilme.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, String>{}