import modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Cômoda", "Cômoda Vertical");

        try(Connection connection = new ConectionFactory().recuperarConexao()) {

            String sql = "INSERT INTO PRODUTOS (NOME, DESCRICAO) VALUES (?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, comoda.getNome());
                pstm.setString(2, comoda.getDescricao());

                pstm.execute();

                try(ResultSet rst = pstm.getGeneratedKeys()){
                    while(rst.next()){
                        comoda.setId(rst.getInt(1));
                    }
                }
            }
        }
        System.out.println(comoda);
    }
}
