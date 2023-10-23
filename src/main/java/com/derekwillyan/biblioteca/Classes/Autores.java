package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;

public class Autores {
    private SimpleStringProperty nome;
    private SimpleStringProperty nascimento;
    private SimpleStringProperty nacionalidade;

    public Autores(String nome, String nascimento, String nacionalidade) {
        this.nome = new SimpleStringProperty(nome);
        this.nascimento = new SimpleStringProperty(nascimento);
        this.nacionalidade = new SimpleStringProperty(nacionalidade);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getNascimento() {
        return nascimento.get();
    }

    public SimpleStringProperty nascimentoProperty() {
        return nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade.get();
    }

    public SimpleStringProperty nacionalidadeProperty() {
        return nacionalidade;
    }
}
