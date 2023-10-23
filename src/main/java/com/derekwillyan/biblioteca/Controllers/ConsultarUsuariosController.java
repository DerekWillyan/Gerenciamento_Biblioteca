package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Usuarios;
import com.derekwillyan.biblioteca.HelloApplication;
import com.derekwillyan.biblioteca.Models.ConsultarAutorModel;
import com.derekwillyan.biblioteca.Models.ConsultarUsuariosModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConsultarUsuariosController {
    @FXML
    private TableView<Usuarios> table;
    @FXML
    private TableColumn<Usuarios, String> nome;
    @FXML
    private TableColumn<Usuarios, String> cpf;
    @FXML
    private TableColumn<Usuarios, String> nascimento;
    @FXML
    private TableColumn<Usuarios, String> telefone;
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
        this.nome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        this.cpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        this.nascimento.setCellValueFactory(cellData -> cellData.getValue().nascimentoProperty());
        this.telefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();
    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarUsuariosModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
