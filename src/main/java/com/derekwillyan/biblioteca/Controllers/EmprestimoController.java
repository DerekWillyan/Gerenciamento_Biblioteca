package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.Models.EmprestimoModel;
import com.derekwillyan.biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmprestimoController {
    @FXML
    private ComboBox livro;
    @FXML
    private DatePicker dataEmp;
    @FXML
    private DatePicker dataDev;
    @FXML
    private ComboBox usuario;
    @FXML
    private ComboBox funcionario;
    @FXML
    private Button voltar;
    @FXML
    private Button realizarEmprestimo;

    @FXML
    public void onbtntRealizarEmprestimo() throws SQLException {
        EmprestimoModel.realizarEmprestimo(this.dataEmp, this.dataDev);
    }
    @FXML
    public void onbtnVoltar(){
        HelloApplication.cena("Home");
    }

    public void initialize() {
        EmprestimoModel.popularLivro(this.livro);
        EmprestimoModel.popularUsuario(this.usuario);
        EmprestimoModel.popularFuncionario(this.funcionario);
    }
}
