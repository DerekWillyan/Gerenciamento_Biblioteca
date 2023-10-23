package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

public class Funcionarios {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty cpf;
    private final SimpleStringProperty cargo;

    public Funcionarios(String nomeFunc, String cpfFunc, String cargoFunc) {
        this.nome = new SimpleStringProperty(nomeFunc);
        this.cpf = new SimpleStringProperty(cpfFunc);
        this.cargo = new SimpleStringProperty(cargoFunc);
    }
    public ObservableValue<String> nomeProperty() {
        return nome;
    }

    public ObservableValue<String> cpfProperty() {
        return cpf;
    }

    public ObservableValue<String> cargoProperty() {
        return cargo;
    }

    public String getNome() {return nome.get();}
}
