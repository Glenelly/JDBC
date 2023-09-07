import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        ConectionFactory conectionFactory = new ConectionFactory();
        Connection connection = conectionFactory.recuperarConexao();

        Statement stm = connection.createStatement();
        boolean resultados = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTOS");

        ResultSet rst = stm.getResultSet();
        while(rst.next()){
            int id = rst.getInt("ID");
            System.out.println("ID: " + id);

            String nome = rst.getString("nome");
            System.out.println("Nome: " + nome);

            String descricao = rst.getString("descricao");
            System.out.println("Descrição: " + descricao);

            System.out.println("----------------------------");
        }

        connection.close();
    }
}
