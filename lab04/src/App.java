import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Good Evening!");
        String url = "jdbc:postgresql://db.rfdccujyluhkjujhnjti.supabase.co:5432/postgres?user=postgres&password=Gu@1597532";
        Connection connection = DriverManager.getConnection(url);
        String sql = "SELECT * FROM account";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rset = stm.executeQuery();
        
        while(rset.next()){
            long accountNumber = rset.getLong("accountNumber");
            double amount = rset.getLong("amount");
            System.out.print("Account number: " + accountNumber);
            System.err.println("Amount R$ " + amount);
        }
    }

    public static void delete() throws SQLException {
        System.out.print("Número de uma conta já existente: ");
        long nro = Long.parseLong (System.console().readLine());
        String url = System.getenv("jdbc:postgresql://db.rfdccujyluhkjujhnjti.supabase.co:5432/postgres?user=postgres&password=Gu@1597532");
        Connection c = DriverManager.getConnection(url);
        String sql = "DELETE FROM account WHERE accountNumber=?";
        PreparedStatement prepstm = c.prepareStatement (sql) ;
        prepstm.setLong(1, nro);
        int ret = prepstm. executeUpdate();
        System.out.println("Número de registros apagados: " + ret);
        c.close();
    }

    public static void create()throws SQLException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Number for the new account: ");
        long nro = scanner.nextLong();
    
        System.out.print("New account balance:");
        BigDecimal amount = scanner.nextBigDecimal();
    
        String url = System.getenv("jdbc:postgresql://db.rfdccujyluhkjujhnjti.supabase.co:5432/postgres?user=postgres&password=Gu@1597532");
    
        String sql = "INSERT INTO account VALUES (?,?)";
    
        try (Connection c = DriverManager.getConnection(url);
            PreparedStatement prepstm = c.prepareStatement(sql)) {
        
            prepstm.setLong(1, nro);
            prepstm.setBigDecimal(2, amount);
        
            int ret = prepstm.executeUpdate();
            System.out.println("Number of records entered: " + ret);
        }
    }
}
