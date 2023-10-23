package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Editoras;
import com.derekwillyan.biblioteca.Classes.Funcionarios;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarEditoraModel {
    public static void preencherTabela(TableView<Editoras> tabelaEditoras) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewEditoras");
            while (consulta.next()) {
                String nome = consulta.getString("Nome");
                String endereco = consulta.getString("Endereço");
                String telefone = consulta.getString("Telefone");
                tabelaEditoras.getItems().add(new Editoras(nome, endereco, telefone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }
}
