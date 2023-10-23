package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FuncionariosModal {

    public static int catSelecionada = 0;
    public static void popularComboBox(ComboBox comboBox){
        BancoDeDados bancoDeDados;
        try {
            bancoDeDados = new BancoDeDados();

            // Defina a consulta SQL para obter os nomes dos livros e seus IDs
            String sql = "SELECT * FROM Cargos";

            ResultSet resultado = bancoDeDados.executarConsulta(sql);

            // Crie um mapa para associar os nomes dos livros aos IDs
            Map<String, Integer> mapaLivros = new HashMap<>();

            // Crie uma lista observável para armazenar os nomes dos livros
            ObservableList<String> listaNomesLivros = FXCollections.observableArrayList();

            // Preencha o mapa e a lista observável
            while (resultado.next()) {
                int codCatLivro = resultado.getInt("codigo_cargo");
                String nomeLivro = resultado.getString("Nome_cargo");
                mapaLivros.put(nomeLivro, codCatLivro);
                listaNomesLivros.add(nomeLivro);
            }

            // Defina os valores do ComboBox com a lista observável
            comboBox.setItems(listaNomesLivros);

            // Configure um ouvinte de seleção para o ComboBox
            comboBox.setOnAction(event -> {
                String nomeSelecionado = (String) comboBox.getValue();
                int idSelecionado = mapaLivros.get(nomeSelecionado);
                catSelecionada = idSelecionado;
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
    /*--- Mascaras ---*/
    public static void cpfMascara(TextField cpf){
        StringConverter<String> cpfConverter = new StringConverter<String>() {
            @Override
            public String toString(String cpf) {
                if (cpf == null || cpf.length() != 11) {
                    return "";
                }
                return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
            }

            @Override
            public String fromString(String string) {
                return string.replaceAll("[^\\d]", ""); // Remove todos os caracteres não numéricos
            }
        };
        // Crie um TextFormatter usando o StringConverter e aplique-o ao TextField
        TextFormatter<String> cpfFormatter = new TextFormatter<>(cpfConverter);
        cpf.setTextFormatter(cpfFormatter);
    }
    public static void adicionarFuncionario(TextField nome, TextField cpf, TextField endereco) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try {
            String[] colunas = {"Nome_funcionario", "CPF_funcionario", "codigo_cargo", "Endereco_funcionario"};
            String[] valores = {nome.getText(), cpf.getText(), String.valueOf(catSelecionada), endereco.getText()};
            bd.inserir("Funcionarios", colunas, valores);
            exibirAlerta("Cadastrado com Sucesso!!!!!", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Houve um erro no Cadastro!!!!!", Alert.AlertType.ERROR);
        } finally {
            bd.fecharConexao();
        }
    }
}
