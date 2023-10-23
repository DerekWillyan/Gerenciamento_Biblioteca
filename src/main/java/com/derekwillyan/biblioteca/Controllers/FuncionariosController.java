package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.FuncionariosModal;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FuncionariosController implements Initializable {
    @FXML
    private TextField nomeFunc;
    @FXML
    private TextField cpf;
    @FXML
    private ComboBox comboBox;
    @FXML
    private TextField endereco;
    @FXML
    private Button voltar;
    @FXML
    private Button adicionar;

    @FXML
    public void onbtnAdicionar() throws SQLException {
        FuncionariosModal.adicionarFuncionario(this.nomeFunc, this.cpf, this.endereco);
        this.nomeFunc.setText("");
        this.cpf.setText("");
        this.endereco.setText("");
    }
    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FuncionariosModal.cpfMascara(this.cpf);
        this.nomeFunc.textProperty().addListener((observable, oldValue, newValue) -> {
            newValue = newValue.replaceAll("^[a-z]", String.valueOf(newValue.charAt(0)).toUpperCase());
            this.nomeFunc.setText(newValue);
        });
    }
    public void Combo(){
        FuncionariosModal.popularComboBox(this.comboBox);
    }
}
