package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.AutorModel;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AutoresController implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private DatePicker data;
    @FXML
    private TextField nacionalidade;
    @FXML
    private Button voltar;
    @FXML
    private Button adicionar;

    @FXML
    public void onbtnAdicionar() throws SQLException {
        AutorModel.adicionarAutor(this.nome, this.data, this.nacionalidade);
        this.nome.setText("");
        this.data.setValue(null);
        this.nacionalidade.setText("");
    }
    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nome.textProperty().addListener((observable, oldValue, newValue) -> {
            newValue = newValue.replaceAll("^[a-z]", String.valueOf(newValue.charAt(0)).toUpperCase());
            this.nome.setText(newValue);
        });
    }
}
