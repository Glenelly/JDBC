import java.sql.Connection;
import java.sql.SQLException;

public class Loja_Virtual {
    public static void main(String[] args) throws SQLException {

        ConectionFactory conectionFactory = new ConectionFactory();
        Connection connection = conectionFactory.recuperarConexao();

        System.out.println("Fechando Conexão!!");

        connection.close();
    }
}
