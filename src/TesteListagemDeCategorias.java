import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConectionFactory().recuperarConexao()){

            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();
            listaDeCategorias.forEach(ct -> {
                System.out.println(ct.getNome());
                try {
                    for(Produto produto : new ProdutoDAO(connection).buscar(ct)){
                        System.out.println(ct.getNome() + " - " + produto.getNome());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
