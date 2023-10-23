package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;

public class Editoras {
    private SimpleStringProperty nome;
    private SimpleStringProperty endereco;
    private SimpleStringProperty telefone;

    public Editoras(String nome, String endereco, String telefone) {
        this.nome = new SimpleStringProperty(nome);
        this.endereco = new SimpleStringProperty(endereco);
        this.telefone = new SimpleStringProperty(telefone);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getEndereco() {
        return endereco.get();
    }

    public SimpleStringProperty enderecoProperty() {
        return endereco;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }
}
