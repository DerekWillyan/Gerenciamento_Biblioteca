package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.EditoraModel;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditoraController implements Initializable {
    @FXML
    private TextField nomeEditora;
    @FXML
    private TextField endereco;
    @FXML
    private TextField telefone;
    @FXML
    private Button voltar;
    @FXML
    private Button adicionar;

    @FXML
    public void onbtnAdicionar () throws SQLException {
        EditoraModel.adicionarEditora(this.nomeEditora, this.endereco, this.telefone);
        this.nomeEditora.setText("");
        this.endereco.setText("");
        this.telefone.setText("");
    }
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EditoraModel.mascaraTelefone(this.telefone);
    }
}
