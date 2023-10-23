package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Classes.Emprestimos;
import com.derekwillyan.biblioteca.Classes.Funcionarios;
import com.derekwillyan.biblioteca.HelloApplication;
import com.derekwillyan.biblioteca.Models.ConsultarEditoraModel;
import com.derekwillyan.biblioteca.Models.ConsultarEmprestimoModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConsultarEmprestimosController {
    @FXML
    private TableView<Emprestimos> table;
    @FXML
    private TableColumn<Emprestimos, String> codigoTab;
    @FXML
    private TableColumn<Emprestimos, String> livroTab;
    @FXML
    private TableColumn<Emprestimos, String> dataEmpTab;
    @FXML
    private TableColumn<Emprestimos, String> dataDevTab;
    @FXML
    private TableColumn<Emprestimos, String> usuarioTab;
    @FXML
    private TableColumn<Emprestimos, String> funcionariosTab;
    @FXML
    private Button voltar;

    private final Duration delay = Duration.seconds(1); // Atraso antes de atualizar (5 segundos)
    private Timeline timeline;

    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    public void initialize (){
        this.codigoTab.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        this.livroTab.setCellValueFactory(cellData -> cellData.getValue().livroProperty());
        this.dataEmpTab.setCellValueFactory(cellData -> cellData.getValue().dataEmprestimoProperty());
        this.dataDevTab.setCellValueFactory(cellData -> cellData.getValue().dataDevolutivaProperty());
        this.usuarioTab.setCellValueFactory(cellData -> cellData.getValue().usuarioProperty());
        this.funcionariosTab.setCellValueFactory(cellData -> cellData.getValue().funcionarioProperty());
        timeline = new Timeline(
                new KeyFrame(delay, this::atualizarTabela)
        );
        timeline.play();

    }
    private void atualizarTabela(ActionEvent event){
        this.table.getItems().clear();
        try {
            ConsultarEmprestimoModel.preencherTabela(this.table);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
