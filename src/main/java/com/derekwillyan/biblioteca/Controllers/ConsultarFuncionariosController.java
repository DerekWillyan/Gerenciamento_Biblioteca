package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Funcionarios;
import com.derekwillyan.biblioteca.HelloApplication;
import com.derekwillyan.biblioteca.Models.ConsultarFuncionariosModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConsultarFuncionariosController {
    @FXML
    private TableView<Funcionarios> table;
    @FXML
    private TableColumn<Funcionarios, String> nomeFunc;
    @FXML
    private TableColumn<Funcionarios, String> cpf;
    @FXML
    private TableColumn<Funcionarios, String> cargo;
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
        this.nomeFunc.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        this.cpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        this.cargo.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();
    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarFuncionariosModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
