package dao;

import modelo.Categoria;
import modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final Connection connection;

    public ProdutoDAO(Connection connection ){
        this.connection = connection;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = "INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES (?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Executando a query de listar categoria");

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTOS";

        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Executando a query de buscar por categoria");

        String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTOS WHERE CATEGORIA_ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)){
            pstm.setInt(1, ct.getId());
            pstm.execute();

            try(ResultSet rst = pstm.getResultSet()){
                while(rst.next()){
                    Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}

