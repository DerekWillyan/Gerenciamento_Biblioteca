package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Livros;
import com.derekwillyan.biblioteca.HelloApplication;
import com.derekwillyan.biblioteca.Models.ConsultarLivroModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConsultarLivroController {
    @FXML
    private TableView<Livros> table;
    @FXML
    private TableColumn<Livros, String> isbn;
    @FXML
    private TableColumn<Livros, String> livro;
    @FXML
    private TableColumn<Livros, String> autor;
    @FXML
    private TableColumn<Livros, String> anoPubli;
    @FXML
    private TableColumn<Livros, String> editora;
    @FXML
    private TableColumn<Livros, String> categoria;
    @FXML
    private TableColumn<Livros, String> quantidade;
    @FXML
    private Button voltar;

    private final Duration delay = Duration.seconds(1); // Atraso antes de atualizar (5 segundos)
    private Timeline timeline;

    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    public void initialize() {
        this.table.getItems().clear();
        this.isbn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
        this.livro.setCellValueFactory(cellData -> cellData.getValue().livroProperty());
        this.autor.setCellValueFactory(cellData -> cellData.getValue().autorProperty());
        this.anoPubli.setCellValueFactory(cellData -> cellData.getValue().anoProperty());
        this.editora.setCellValueFactory(cellData -> cellData.getValue().editoraProperty());
        this.categoria.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        this.quantidade.setCellValueFactory(cellData -> cellData.getValue().disponivelProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();
    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarLivroModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
