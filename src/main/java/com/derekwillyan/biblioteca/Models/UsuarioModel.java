package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import java.sql.SQLException;

public class UsuarioModel {
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
    public static void mascaraTelefone(TextField tel){
        tel.textProperty().addListener(new ChangeListener<String>() {
            private boolean ignoreChange = false;

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (ignoreChange || newValue == null) {
                    return;
                }

                // Remove caracteres não numéricos
                String texto = newValue.replaceAll("[^0-9]", "");

                // Aplica a máscara (XX) X XXXX-XXXX
                StringBuilder formattedText = new StringBuilder();

                if (texto.length() > 0) {
                    formattedText.append("(");
                    if (texto.length() >= 2) {
                        formattedText.append(texto.substring(0, 2));
                    } else {
                        formattedText.append(texto);
                    }
                    formattedText.append(")");
                }

                if (texto.length() > 2) {
                    formattedText.append(" " + texto.charAt(2));
                }

                if (texto.length() > 3) {
                    formattedText.append(" " + texto.substring(3, Math.min(7, texto.length())));
                }

                if (texto.length() > 7) {
                    formattedText.append("-" + texto.substring(7, Math.min(11, texto.length())));
                }

                ignoreChange = true;
                tel.setText(formattedText.toString());
                ignoreChange = false;
            }
        });
    }
    /*--- Funções ---*/
    public static void cadastrarUsuarios(TextField nome, TextField cpf, DatePicker data, TextField endereco, TextField teleforne) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try {
            String[] colunas = {"Nome_usuario","CPF_usuario", "Endereco_usuario", "Nascimento_usuario", "Telefone_usuario"};
            String[] valores = {nome.getText(), cpf.getText(), endereco.getText(), String.valueOf(data.getValue()), teleforne.getText()};
            bd.inserir("Usuarios", colunas, valores);
            exibirAlerta("Cadastrado com Sucesso!!!!!", Alert.AlertType.CONFIRMATION);
        }catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Houve um erro em cadastrar usuários", Alert.AlertType.ERROR);
        } finally {
            bd.fecharConexao();
        }
    }
}
