package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;

public class Usuarios {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty cpf;
    private final SimpleStringProperty nascimento;
    private final SimpleStringProperty telefone;

    public Usuarios(String nome, String cpf, String nascimento, String telefone) {
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.nascimento = new SimpleStringProperty(nascimento);
        this.telefone = new SimpleStringProperty(telefone);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public String getCpf() {
        return cpf.get();
    }

    public SimpleStringProperty cpfProperty() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento.get();
    }

    public SimpleStringProperty nascimentoProperty() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }
}
