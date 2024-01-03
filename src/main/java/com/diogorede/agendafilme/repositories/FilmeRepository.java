package com.diogorede.agendafilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diogorede.agendafilme.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, String>{}