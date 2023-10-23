package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Autores;
import com.derekwillyan.biblioteca.Classes.Emprestimos;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarEmprestimoModel {
    public static void preencherTabela(TableView<Emprestimos> tabelaEmprestimo) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewEmprestimo");
            while (consulta.next()) {
                String codigo = consulta.getString("Código");
                String livro = consulta.getString("Livro");
                String dataEmp = consulta.getString("Data de Empréstimo");
                String dataDev = consulta.getString("Data de Devolutiva");
                String usuario = consulta.getString("Usuário");
                String funcionario = consulta.getString("Funcionário");
                tabelaEmprestimo.getItems().add(new Emprestimos(codigo, livro, dataEmp, dataDev, usuario, funcionario));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }
}
