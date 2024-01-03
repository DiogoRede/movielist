package com.diogorede.agendafilme.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Nome não informado")
    private String nome;

    private String indicacao;

    @NotNull(message = "Assistido não informado")
    private boolean assistido;

    @NotNull(message = "Prioridade não informado")
    private int prioridade;
    
    private String descricao;

    public Filme(String nome, String indicacao, int prioridade, String descricao, boolean assistido) {
        this.nome = nome;
        this.indicacao = indicacao;
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.assistido = assistido;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIndicacao() {
        return indicacao;
    }
    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAssistido() {
        return assistido;
    }

    public void setAssistido(boolean assistido) {
        this.assistido = assistido;
    }

}