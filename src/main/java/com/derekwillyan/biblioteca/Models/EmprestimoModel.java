package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmprestimoModel {

    public static String isbnLivro;
    public static int codUsuario;
    public static int codFuncionario;

    /*--- Alerta ---*/
    private static void exibirAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    /*--- ComboBoxes ---*/
    public static void popularLivro(ComboBox comboBox) {
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT ISBN_livro, Nome_livro FROM Livros";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, String> mapaLivros = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesLivros = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                String idLivro = resultado.getString("ISBN_livro");
                String nomeLivro = resultado.getString("Nome_livro");
                mapaLivros.put(nomeLivro, idLivro);
                listaNomesLivros.add(nomeLivro);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBox.setItems(listaNomesLivros);

            // Configure um ouvinte de seleção para o ComboBox
            comboBox.setOnAction(event -> {
                String nomeSelecionado = (String) comboBox.getValue();
                String idSelecionado = mapaLivros.get(nomeSelecionado);
                isbnLivro = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void popularUsuario(ComboBox comboBox) {
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT codigo_usuario, Nome_usuario FROM Usuarios";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaUsuarios = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesUsuarios = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int idUsuario = resultado.getInt("codigo_usuario");
                String nomeUsuario = resultado.getString("Nome_usuario");
                mapaUsuarios.put(nomeUsuario, idUsuario);
                listaNomesUsuarios.add(nomeUsuario);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBox.setItems(listaNomesUsuarios);

            // Configure um ouvinte de seleção para o ComboBox
            comboBox.setOnAction(event -> {
                String nomeSelecionado = (String) comboBox.getValue();
                int idSelecionado = mapaUsuarios.get(nomeSelecionado);
                codUsuario = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void popularFuncionario(ComboBox comboBox) {
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT codigo_funcionario, Nome_funcionario FROM Funcionarios";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaFuncionarios = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesFuncionarios = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int idFuncionario = resultado.getInt("codigo_funcionario");
                String nomeFuncionario = resultado.getString("Nome_funcionario");
                mapaFuncionarios.put(nomeFuncionario, idFuncionario);
                listaNomesFuncionarios.add(nomeFuncionario);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBox.setItems(listaNomesFuncionarios);

            // Configure um ouvinte de seleção para o ComboBox
            comboBox.setOnAction(event -> {
                String nomeSelecionado = (String) comboBox.getValue();
                int idSelecionado = mapaFuncionarios.get(nomeSelecionado);
                codFuncionario = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*--- Funções ---*/
    public static void realizarEmprestimo(DatePicker dataEmp, DatePicker dataDev) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try {
            String[] colunas = {"ISBN_livro", "Data_emprestimo","Data_devolutiva","codigo_usuario", "codigo_funcionario"};
            String[] valores = {isbnLivro, String.valueOf(dataEmp.getValue()), String.valueOf(dataDev.getValue()), String.valueOf(codUsuario), String.valueOf(codFuncionario)};
            bd.inserir("Emprestimos", colunas, valores);
            exibirAlerta("Emprestimo realizado com sucesso !!!!!", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Ouve um erro na realização do emprestimo", Alert.AlertType.ERROR);
        }finally {
            bd.fecharConexao();
        }
    }
}
