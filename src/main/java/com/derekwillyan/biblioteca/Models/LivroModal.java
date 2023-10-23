package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LivroModal {
    public static int codAutor = 1;
    public static int codEditora;
    public static int codCategoria;

    /*--- ComboBoxes ---*/
    public static void popularAutores(ComboBox comboBoxAutores){
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT codigo_autor, Nome_autor FROM Autores";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaAutores = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesAutores = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int codigoAutores = resultado.getInt("codigo_autor");
                String nomeAutores = resultado.getString("Nome_autor");
                mapaAutores.put(nomeAutores, codigoAutores);
                listaNomesAutores.add(nomeAutores);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBoxAutores.setItems(listaNomesAutores);

            // Configure um ouvinte de seleção para o ComboBox
            comboBoxAutores.setOnAction(event -> {
                String nomeSelecionado = (String) comboBoxAutores.getValue();
                int idSelecionado = mapaAutores.get(nomeSelecionado);
                codAutor = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void popularEditoras(ComboBox comboBoxEditoras){
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT codigo_editora, Nome_editora FROM Editoras";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaEditoras = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesEditoras = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int codigoEditoras = resultado.getInt("codigo_editora");
                String nomeEditoras = resultado.getString("Nome_editora");
                mapaEditoras.put(nomeEditoras, codigoEditoras);
                listaNomesEditoras.add(nomeEditoras);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBoxEditoras.setItems(listaNomesEditoras);

            // Configure um ouvinte de seleção para o ComboBox
            comboBoxEditoras.setOnAction(event -> {
                String nomeSelecionado = (String) comboBoxEditoras.getValue();
                int idSelecionado = mapaEditoras.get(nomeSelecionado);
                codEditora = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void popularCategorias(ComboBox comboBoxCategorias){
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT codigo_categoria, Nome_categoria FROM Categorias";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaCategorias = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesCategorias = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int codigoCategorias = resultado.getInt("codigo_categoria");
                String nomeCategorias = resultado.getString("Nome_categoria");
                mapaCategorias.put(nomeCategorias, codigoCategorias);
                listaNomesCategorias.add(nomeCategorias);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBoxCategorias.setItems(listaNomesCategorias);

            // Configure um ouvinte de seleção para o ComboBox
            comboBoxCategorias.setOnAction(event -> {
                String nomeSelecionado = (String) comboBoxCategorias.getValue();
                int idSelecionado = mapaCategorias.get(nomeSelecionado);
                codCategoria = idSelecionado;
            });

            // Feche a conexão com o banco de dados
            bancoDeDados.fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*--- Alerta ---*/
    private static void exibirAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    /*--- Funções ---*/
    public static void adicionarLivro(TextField isbn, TextField nome, DatePicker data, TextField quantidade) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try{
            String[] colunas = {"ISBN_livro", "Nome_livro", "codigo_autor", "Ano_Publicacao", "codigo_editora", "codigo_categoria", "Quantidade_disponivel"};
            String codCategoriac;
            String[] valores = {isbn.getText(), nome.getText(), String.valueOf(codAutor), String.valueOf(data.getValue()), String.valueOf(codEditora), String.valueOf(codCategoria), quantidade.getText()};
            bd.inserir("Livros", colunas, valores);
            exibirAlerta("Cadastrado com Sucesso!!!", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Cadastrado com Sucesso!!!", Alert.AlertType.ERROR);
        }finally {
            bd.fecharConexao();
        }
    }
}
