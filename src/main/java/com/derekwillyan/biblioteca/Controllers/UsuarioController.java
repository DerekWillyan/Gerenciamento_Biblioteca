package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.UsuarioModel;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private DatePicker data;
    @FXML
    private TextField endereco;
    @FXML
    private TextField telefone;
    @FXML
    private Button cadastrar;
    @FXML
    private Button voltar;

    private TextFormatter<Number> formatter = new TextFormatter<>(new NumberStringConverter());

    @FXML
    public void onbtnCadastrarUsuario() throws SQLException {
        UsuarioModel.cadastrarUsuarios(nome,cpf,data,endereco,telefone);
        this.nome.setText("");
        this.cpf.setText("");
        this.data.setValue(null);
        this.endereco.setText("");
        this.telefone.setText("");
    }
    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UsuarioModel.cpfMascara(this.cpf);
        UsuarioModel.mascaraTelefone(this.telefone);
        this.nome.textProperty().addListener((observable, oldValue, newValue) -> {
            newValue = newValue.replaceAll("^[a-z]", String.valueOf(newValue.charAt(0)).toUpperCase());
            this.nome.setText(newValue);
        });
    }
}
