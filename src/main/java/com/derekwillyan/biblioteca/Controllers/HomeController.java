package com.derekwillyan.biblioteca.Controllers;

import com.derekwillyan.biblioteca.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {
    @FXML
    private Button emprestimo;
    @FXML
    private Button user;
    @FXML
    private Button editora;
    @FXML
    private Button funcionario;
    @FXML
    private Button autor;
    @FXML
    private Button consultarFunc;
    @FXML
    private Button consultarUsers;
    @FXML
    private Button consultarEditoras;
    @FXML
    private Button consultarLivros;
    @FXML
    private Button consultarAutores;
    @FXML
    private Button consultarEmprestimos;

    @FXML
    public void onbtnUsuario(){
        HelloApplication.cena("Usuario");
    }
    @FXML
    public void onbtnEditora(){
        HelloApplication.cena("Editora");
    }
    @FXML
    public void onbtnFuncionario(){
        HelloApplication.cena("Funcionario");
    }
    @FXML
    public void onbtnAutor(){
        HelloApplication.cena("Autores");
    }
    @FXML
    public void onbtnLivros(){
        HelloApplication.cena("Livros");
    }
    @FXML
    public void onbtnEmprestimo(){
        HelloApplication.cena("Emprestimos");
    }
    @FXML
    public void onbtnConsultarFunc(){
        HelloApplication.cena("ConsultarFunc");
    }
    @FXML
    public void onbtnConsultarUsers(){
        HelloApplication.cena("ConsultarUsers");
    }
    @FXML
    public void onbtnConsultarEditoras(){
        HelloApplication.cena("ConsultarEditoras");
    }
    @FXML
    public void onbtnConsultarLivros(){
        HelloApplication.cena("ConsultarLivros");
    }
    @FXML
    public void onbtnConsultarAutores(){
        HelloApplication.cena("ConsultarAutores");
    }
    @FXML
    public void onbtnConsultarEmprestimos(){
        HelloApplication.cena("ConsultarEmprestimos");
    }

}
