package dao;

import modelo.Produto;

import java.sql.*;

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
}

