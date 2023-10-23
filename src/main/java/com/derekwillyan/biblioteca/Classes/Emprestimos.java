package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;

public class Emprestimos {
    private final SimpleStringProperty codigo;
    private final SimpleStringProperty livro;
    private final SimpleStringProperty dataEmprestimo;
    private final SimpleStringProperty dataDevolutiva;
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty funcionario;


    public Emprestimos(String codigo,String livro, String dataEmprestimo, String dataDevolutiva, String usuario, String funcionario) {
        this.codigo = new SimpleStringProperty(codigo);
        this.livro = new SimpleStringProperty(livro);
        this.dataEmprestimo = new SimpleStringProperty(dataEmprestimo);
        this.dataDevolutiva = new SimpleStringProperty(dataDevolutiva);
        this.usuario = new SimpleStringProperty(usuario);
        this.funcionario = new SimpleStringProperty(funcionario);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public SimpleStringProperty codigoProperty() {
        return codigo;
    }

    public String getLivro() {
        return livro.get();
    }

    public SimpleStringProperty livroProperty() {
        return livro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo.get();
    }

    public SimpleStringProperty dataEmprestimoProperty() {
        return dataEmprestimo;
    }

    public String getDataDevolutiva() {
        return dataDevolutiva.get();
    }

    public SimpleStringProperty dataDevolutivaProperty() {
        return dataDevolutiva;
    }

    public String getUsuario() {
        return usuario.get();
    }

    public SimpleStringProperty usuarioProperty() {
        return usuario;
    }

    public String getFuncionario() {
        return funcionario.get();
    }

    public SimpleStringProperty funcionarioProperty() {
        return funcionario;
    }
}
