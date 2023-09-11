import dao.ProdutoDAO;
import modelo.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Mesa", "Mesa de jantar");

        try(Connection connection = new ConectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);
            //Lista = persistenciaProduto.listar();
        }
    }
}
