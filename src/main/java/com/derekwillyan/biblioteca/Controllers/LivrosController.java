package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.ConsultarFuncionariosModel;
import com.derekwillyan.biblioteca.Models.LivroModal;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LivrosController {
    @FXML
    private TextField isbn;
    @FXML
    private TextField nome;
    @FXML
    private ComboBox autores;
    @FXML
    private DatePicker anoPubli;
    @FXML
    private ComboBox editora;
    @FXML
    private ComboBox categoria;
    @FXML
    private TextField quantidade;
    @FXML
    private Button adicionar;
    @FXML
    private Button voltar;

    @FXML
    public void onbtnAdicionar() throws SQLException {
        LivroModal.adicionarLivro(this.isbn, this.nome, this.anoPubli, this.quantidade);
    }
    @FXML
    public void onbtnVoltar() throws SQLException {
        HelloApplication.cena("Home");
    }

    public void initialize() {
        LivroModal.popularAutores(this.autores);
        LivroModal.popularEditoras(this.editora);
        LivroModal.popularCategorias(this.categoria);
    }

}
