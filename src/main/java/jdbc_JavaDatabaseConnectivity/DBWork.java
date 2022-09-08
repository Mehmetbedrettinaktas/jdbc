package jdbc_JavaDatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWork {
    // Postgresql baglantisi methodu.
    Connection con=null;
    public Connection connect_to_db(String dbName, String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
             con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,user,password);
            if (con!=null){
                System.out.println("Baglanti saglandi");
            }else {
                System.out.println("baglanti saglanamadi");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
    // Yeni table olsturma methodu olustur
    public void createTable(Connection con, String tableName){
        Statement statement;
        try {
            String query="Create TABLE "+tableName+ "(empId SERIAL, name VARCHAR(200), email VARCHAR(200), salary INTEGER, PRIMARY KEY(empId)) ";
          statement=  con.createStatement();
          statement.executeUpdate(query);
            System.out.println("table olusturuldu");

        }catch (Exception e){
            System.out.println(e);
        }

    }


}
