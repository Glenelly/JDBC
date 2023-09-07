import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {

        ConectionFactory factory =  new ConectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTOS WHERE ID > ?");
        stm.setInt(1, 2);
        stm.execute();

        int linhasModificadas = stm.getUpdateCount();

        System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
    }
}
