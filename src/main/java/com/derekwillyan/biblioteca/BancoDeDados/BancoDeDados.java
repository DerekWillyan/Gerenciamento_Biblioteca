package com.derekwillyan.biblioteca.BancoDeDados;

import java.sql.*;

public class BancoDeDados {
    private Connection conexao;

    public BancoDeDados() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Biblioteca";
        String usuario = "root";
        String senha = "17082001";
        conexao = DriverManager.getConnection(url, usuario, senha);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public ResultSet executarConsulta(String sql) throws SQLException {
        Statement declaracao = conexao.createStatement();
        ResultSet resultado = declaracao.executeQuery(sql);
        return resultado;
    }

    public int executarAtualizacao(String sql) throws SQLException {
        Statement declaracao = conexao.createStatement();
        int linhasAfetadas = declaracao.executeUpdate(sql);
        return linhasAfetadas;
    }

    public void inserir(String tabela, String[] colunas, String[] valores) throws SQLException {
        String sql = "INSERT INTO " + tabela + " (";
        for (int i = 0; i < colunas.length; i++) {
            sql += colunas[i];
            if (i < colunas.length - 1) {
                sql += ", ";
            }
        }
        sql += ") VALUES (";
        for (int i = 0; i < valores.length; i++) {
            sql += "'" + valores[i] + "'";
            if (i < valores.length - 1) {
                sql += ", ";
            }
        }
        sql += ")";
        executarAtualizacao(sql);
    }

    public void atualizar(String tabela, String[] colunas, String[] valores, String where) throws SQLException {
        String sql = "UPDATE " + tabela + " SET ";
        for (int i = 0; i < colunas.length; i++) {
            sql += colunas[i] + "='" + valores[i] + "'";
            if (i < colunas.length - 1) {
                sql += ", ";
            }
        }
        sql += " WHERE " + where;
        executarAtualizacao(sql);
    }

    public void deletar(String tabela, String where) throws SQLException {
        String sql = "DELETE FROM " + tabela + " WHERE " + where;
        executarAtualizacao(sql);
    }
}
