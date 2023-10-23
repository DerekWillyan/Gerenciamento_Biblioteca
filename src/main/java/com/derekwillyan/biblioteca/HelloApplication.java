package com.derekwillyan.biblioteca;

import com.derekwillyan.biblioteca.Controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage primaryStage;
    public static FXMLLoader loaderConsultEmp,loaderEmprestimo,loaderLivros,loaderFuncionarios,loaderConsultFunc,loaderConsAutor, loaderConsUsers, loaderConsEditoras, loaderConsLivros;
    public static Scene sceneConsultarEmp,sceneConsultarAutor,sceneConsultarLivro,sceneConsultarEditora,sceneConsultUsuarios,sceneConsultFunc,sceneEmprestimo,sceneHome, sceneUsuario, sceneEditora, sceneFuncionario, sceneAutores, sceneLivros;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        try {
            Parent FXMLHome = FXMLLoader.load(getClass().getResource("/com/derekwillyan/biblioteca/Home.fxml"));
            sceneHome = new Scene(FXMLHome);

            Parent FXMLUsuario = FXMLLoader.load(getClass().getResource("/com/derekwillyan/biblioteca/Usuario.fxml"));
            sceneUsuario = new Scene(FXMLUsuario);

            Parent FXMLEditora = FXMLLoader.load(getClass().getResource("/com/derekwillyan/biblioteca/Editora.fxml"));
            sceneEditora = new Scene(FXMLEditora);

            loaderFuncionarios = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/Funcionarios.fxml"));
            Parent FXMLFuncionario = loaderFuncionarios.load();
            sceneFuncionario = new Scene(FXMLFuncionario);

            Parent FXMLAutores = FXMLLoader.load(getClass().getResource("/com/derekwillyan/biblioteca/Autor.fxml"));
            sceneAutores = new Scene(FXMLAutores);

            loaderLivros = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/Livros.fxml"));
            Parent FXMLLivros = loaderLivros.load();
            sceneLivros = new Scene(FXMLLivros);

            loaderEmprestimo = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/Emprestimo.fxml"));
            Parent FXMLEmprestimo = loaderEmprestimo.load();
            sceneEmprestimo = new Scene(FXMLEmprestimo);

            loaderConsultFunc = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaFuncionarios.fxml"));
            Parent FXMLConsFunc = loaderConsultFunc.load();
            sceneConsultFunc = new Scene(FXMLConsFunc);

            loaderConsUsers = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaUsuarios.fxml"));
            Parent FXMLConsUsers = loaderConsUsers.load();
            sceneConsultUsuarios = new Scene(FXMLConsUsers);

            loaderConsEditoras = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaEditoras.fxml"));
            Parent FXMLConsEditora = loaderConsEditoras.load();
            sceneConsultarEditora = new Scene(FXMLConsEditora);

            loaderConsultEmp = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaEmprestimo.fxml"));
            Parent FXMLConsEmprestimo = loaderConsultEmp.load();
            sceneConsultarEmp = new Scene(FXMLConsEmprestimo);

            loaderConsLivros = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaLivros.fxml"));
            Parent FXMLConsLivro = loaderConsLivros.load();
            sceneConsultarLivro = new Scene(FXMLConsLivro);

            loaderConsAutor = new FXMLLoader(getClass().getResource("/com/derekwillyan/biblioteca/ConsultaAutor.fxml"));
            Parent FXMLConsAutor = loaderConsAutor.load();
            sceneConsultarAutor = new Scene(FXMLConsAutor);

            primaryStage.setScene(sceneHome);
            primaryStage.setTitle("Home");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void cena(String cena){
        switch (cena){
            case "Home":
                primaryStage.setScene(sceneHome);
                primaryStage.setTitle("Home");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Usuario":
                primaryStage.setScene(sceneUsuario);
                primaryStage.setTitle("Novo Usuário");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Editora":
                primaryStage.setScene(sceneEditora);
                primaryStage.setTitle("Nova Editora");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Funcionario":
                FuncionariosController funcionario = loaderFuncionarios.getController();
                funcionario.Combo();
                primaryStage.setScene(sceneFuncionario);
                primaryStage.setTitle("Novo Funcionário");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Autores":
                primaryStage.setScene(sceneAutores);
                primaryStage.setTitle("Novo Autor");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Livros":
                LivrosController books = loaderLivros.getController();
                books.initialize();
                primaryStage.setScene(sceneLivros);
                primaryStage.setTitle("Novo Livro");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "Emprestimos":
                EmprestimoController emp = loaderEmprestimo.getController();
                emp.initialize();
                primaryStage.setScene(sceneEmprestimo);
                primaryStage.setTitle("Novo Emprestimo");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarFunc":
                ConsultarFuncionariosController func = loaderConsultFunc.getController();
                func.initialize();
                primaryStage.setScene(sceneConsultFunc);
                primaryStage.setTitle("Funcionários");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarUsers":
                ConsultarUsuariosController user = loaderConsUsers.getController();
                user.initialize();
                primaryStage.setScene(sceneConsultUsuarios);
                primaryStage.setTitle("Usuários");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarEditoras":
                ConsultarEditorasController edit = loaderConsEditoras.getController();
                edit.initialize();
                primaryStage.setScene(sceneConsultarEditora);
                primaryStage.setTitle("Editoras");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarLivros":
                ConsultarLivroController livros = loaderConsLivros.getController();
                livros.initialize();
                primaryStage.setScene(sceneConsultarLivro);
                primaryStage.setTitle("Livros");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarAutores":
                ConsultarAutoresController aut = loaderConsAutor.getController();
                aut.atualizarTabela();
                primaryStage.setScene(sceneConsultarAutor);
                primaryStage.setTitle("Autores");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
            case "ConsultarEmprestimos":
                ConsultarEmprestimosController empConsult = loaderConsultEmp.getController();
                empConsult.initialize();
                primaryStage.setScene(sceneConsultarEmp);
                primaryStage.setTitle("Empréstimos");
                primaryStage.setResizable(false);
                primaryStage.show();
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}