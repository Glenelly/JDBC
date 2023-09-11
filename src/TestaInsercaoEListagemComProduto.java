import dao.ProdutoDAO;
import modelo.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        Produto comoda = new Produto("Mesa", "Mesa de jantar");

        try(Connection connection = new ConectionFactory().recuperarConexao()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(connection);
            produtoDAO.salvar(comoda);

            List<Produto> listaDeProdutos = produtoDAO.listar();
            listaDeProdutos.forEach(System.out::println);
        }
    }
}
