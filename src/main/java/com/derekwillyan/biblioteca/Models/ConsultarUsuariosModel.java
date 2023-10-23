package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Funcionarios;
import com.derekwillyan.biblioteca.Classes.Usuarios;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarUsuariosModel {
    public static void preencherTabela(TableView<Usuarios> tabelaUsuarios) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewUsuarios");
            while (consulta.next()) {
                String nome = consulta.getString("Nome");
                String cpf = consulta.getString("CPF");
                String nascimento = consulta.getString("Nascimento");
                String telefone = consulta.getString("Telefone");
                tabelaUsuarios.getItems().add(new Usuarios(nome, cpf, nascimento, telefone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }
}
