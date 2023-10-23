package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class EditoraModel {
    /*--- Alerta ---*/
    private static void exibirAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    /*--- Máscara ---*/
    public static void mascaraTelefone (TextField telefone){
        telefone.textProperty().addListener(new ChangeListener<String>() {
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
                telefone.setText(formattedText.toString());
                ignoreChange = false;
            }
        });
    }
    /*--- Funções ---*/
    public static void adicionarEditora(TextField nomeEditora, TextField endereco, TextField telefone) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        try {
            String[] colunas = {"Nome_editora", "Endereco_editora", "Telefone_editora"};
            String[] valores = {nomeEditora.getText(), endereco.getText(), telefone.getText()};
            bd.inserir("Editoras", colunas, valores);
            exibirAlerta("Cadastrado com Sucesso!!!!", Alert.AlertType.CONFIRMATION);

        } catch (SQLException e){
            e.printStackTrace();
            exibirAlerta("Algo deu errado", Alert.AlertType.ERROR);
        } finally {
            bd.fecharConexao();
        }
    }
}
