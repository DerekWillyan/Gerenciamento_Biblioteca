package com.derekwillyan.biblioteca.Classes;

import javafx.beans.property.SimpleStringProperty;

public class Livros {
    private SimpleStringProperty isbn;
    private SimpleStringProperty livro;
    private SimpleStringProperty autor;
    private SimpleStringProperty ano;
    private SimpleStringProperty editora;
    private SimpleStringProperty categoria;
    private SimpleStringProperty disponivel;

    public Livros(String isbn, String livro, String autor, String ano, String editora, String categoria, String disponivel) {
        this.isbn = new SimpleStringProperty(isbn);
        this.livro = new SimpleStringProperty(livro);
        this.autor = new SimpleStringProperty(autor);
        this.ano =  new SimpleStringProperty(ano);
        this.editora = new SimpleStringProperty(editora);
        this.categoria = new SimpleStringProperty(categoria);
        this.disponivel = new SimpleStringProperty(disponivel);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public String getLivro() {
        return livro.get();
    }

    public SimpleStringProperty livroProperty() {
        return livro;
    }

    public String getAutor() {
        return autor.get();
    }

    public SimpleStringProperty autorProperty() {
        return autor;
    }

    public String getAno() {
        return ano.get();
    }

    public SimpleStringProperty anoProperty() {
        return ano;
    }

    public String getEditora() {
        return editora.get();
    }

    public SimpleStringProperty editoraProperty() {
        return editora;
    }

    public String getCategoria() {
        return categoria.get();
    }

    public SimpleStringProperty categoriaProperty() {
        return categoria;
    }

    public String getDisponivel() {
        return disponivel.get();
    }

    public SimpleStringProperty disponivelProperty() {
        return disponivel;
    }
}
