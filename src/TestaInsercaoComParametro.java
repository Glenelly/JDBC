import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        ConectionFactory factory = new ConectionFactory();
        Connection connection = factory.recuperarConexao();
        connection.setAutoCommit(false);

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTOS (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

        adicionarVariavel("SmartTV", "45 Polegadas", stm);
        adicionarVariavel("Radio", "Radio de bateria", stm);
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException{
        stm.setString(1, nome);
        stm.setString(2, descricao);

        if(nome.equals("Radio")){
            throw new RuntimeException("Não foi possível adicionar o produto");
        }

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            int id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
    }
}
