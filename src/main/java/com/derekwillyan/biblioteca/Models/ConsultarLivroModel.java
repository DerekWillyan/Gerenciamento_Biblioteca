package com.derekwillyan.biblioteca.Models;

import com.derekwillyan.biblioteca.BancoDeDados.BancoDeDados;
import com.derekwillyan.biblioteca.Classes.Livros;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarLivroModel {
    public static void preencherTabela(TableView<Livros> tabelaLivros) throws SQLException {
        BancoDeDados bd = new BancoDeDados();
        ResultSet consulta = null;
        try {
            consulta = bd.executarConsulta("SELECT * FROM viewTabelaLivros");
            while (consulta.next()) {
                String isbn = consulta.getString("ISBN");
                String livro = consulta.getString("Livro");
                String autor = consulta.getString("Autor");
                String anoPubli = consulta.getString("Ano da Publicação");
                String editora = consulta.getString("Editora");
                String categoria = consulta.getString("Categoria");
                String quantidade = consulta.getString("Quantidade Disponível");
                tabelaLivros.getItems().add(new Livros(isbn, livro, autor, anoPubli, editora, categoria, quantidade));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            consulta.close();
            bd.fecharConexao();
        }
    }
}
