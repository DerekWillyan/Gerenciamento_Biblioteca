package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Autores;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarAutorModel {
    public static void preencherTabela(TableView<Autores> tabelaAutores) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewAutores");
            while (consulta.next()) {
                String nome = consulta.getString("Nome");
                String nascimento = consulta.getString("Nascimento");
                String nacionalidade = consulta.getString("Nacionalidade");
                tabelaAutores.getItems().add(new Autores(nome, nascimento, nacionalidade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }
}
