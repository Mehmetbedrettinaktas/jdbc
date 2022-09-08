package jdbc_JavaDatabaseConnectivity.repeat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        // 2. Adim : Database'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/SQL_Batch81","postgres","1234");
        // 3. Adim Statement olustur.
        Statement st=con.createStatement();
    }

}
