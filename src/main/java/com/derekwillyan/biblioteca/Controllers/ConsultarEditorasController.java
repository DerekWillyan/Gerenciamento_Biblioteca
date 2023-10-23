package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Editoras;
import com.derekwillyan.biblioteca.HelloApplication;
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

public class ConsultarEditorasController {
    @FXML
    private TableView<Editoras> table;
    @FXML
    private TableColumn<Editoras, String> nome;
    @FXML
    private TableColumn<Editoras, String> endereco;
    @FXML
    private TableColumn<Editoras, String> telefone;
    @FXML
    private Button voltar;

    private final Duration delay = Duration.seconds(1); // Atraso antes de atualizar (5 segundos)
    private Timeline timeline;

    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }


    public void initialize(){
        this.nome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        this.endereco.setCellValueFactory(cellData -> cellData.getValue().enderecoProperty());
        this.telefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();
    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarEditoraModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
