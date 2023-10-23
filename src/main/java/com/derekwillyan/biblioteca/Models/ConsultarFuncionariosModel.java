package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Funcionarios;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultarFuncionariosModel {
    public static void preencherTabela(TableView<Funcionarios> tabelaFuncionarios) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewFuncionarios");
            while (consulta.next()) {
                String nome = consulta.getString("Nome do Funcionário");
                String cpf = consulta.getString("CPF");
                String cargo = consulta.getString("Cargo");
                tabelaFuncionarios.getItems().add(new Funcionarios(nome, cpf, cargo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }

}
