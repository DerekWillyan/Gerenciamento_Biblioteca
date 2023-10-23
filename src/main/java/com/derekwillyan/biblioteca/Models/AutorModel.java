package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AutorModel {
    /*--- Alerta ---*/
    private static void exibirAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    public static void adicionarAutor(TextField nome, DatePicker data, TextField nascionalidade) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try{
            String[] colunas = {"Nome_autor", "Nascimento_autor", "Nacionalidade_autor"};
            String[] valores = {nome.getText(), String.valueOf(data.getValue()), nascionalidade.getText()};
            bd.inserir("Autores", colunas, valores);
            exibirAlerta("Cadastrado com Sucesso!!!!", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Houve um erro no cadastro!!!!", Alert.AlertType.ERROR);
        }finally {
            bd.fecharConexao();
        }
    }
}
