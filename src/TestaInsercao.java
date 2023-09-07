import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {

        ConectionFactory factory = new ConectionFactory();
        Connection connection = factory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("INSERT INTO PRODUTOS (nome, descricao) VALUES ('MOUSE', 'MOUSE SEM FIO')"
                    , Statement.RETURN_GENERATED_KEYS);

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            int id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
    }
}
