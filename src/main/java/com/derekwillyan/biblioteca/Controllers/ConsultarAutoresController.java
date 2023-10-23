package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Autores;
import com.derekwillyan.biblioteca.HelloApplication;
import com.derekwillyan.biblioteca.Models.ConsultarAutorModel;
import com.derekwillyan.biblioteca.Models.ConsultarEditoraModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConsultarAutoresController{
    @FXML
    private TableView<Autores> table;
    @FXML
    private TableColumn<Autores, String> nome;
    @FXML
    private TableColumn<Autores, String> nascimento;
    @FXML
    private TableColumn<Autores, String> nacionalidade;
    @FXML
    private Button voltar;

    private final Duration delay = Duration.seconds(1); // Atraso antes de atualizar (5 segundos)
    private Timeline timeline;

    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    public void atualizarTabela() {
        this.table.getItems().clear();
        this.nome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        this.nascimento.setCellValueFactory(cellData -> cellData.getValue().nascimentoProperty());
        this.nacionalidade.setCellValueFactory(cellData -> cellData.getValue().nacionalidadeProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();

    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarAutorModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
