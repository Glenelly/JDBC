import java.sql.SQLException;

public class TestaPoolConexoes {

    public static void main(String[] args) throws SQLException {

        ConectionFactory conectionFactory = new ConectionFactory();

        for(int i = 1; i < 20; i++){

            conectionFactory.recuperarConexao();
            System.out.println("Conexão de número: " + i);
        }

    }
}
