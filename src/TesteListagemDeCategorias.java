import dao.CategoriaDAO;
import modelo.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = new ConectionFactory().recuperarConexao()){

            CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
            List<Categoria> listaDeCategorias = categoriaDAO.listar();
            listaDeCategorias.forEach(ct -> System.out.println(ct.getNome()));
        }
    }
}
