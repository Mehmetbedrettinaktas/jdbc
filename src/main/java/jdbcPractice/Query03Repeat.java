package jdbcPractice;

import java.sql.*;

public class Query03Repeat {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        // Statement st=con.createStatement(); daha dinamik oldugu icin PreparedStatement kullaniyoruz
        PreparedStatement ps= con.prepareStatement("SELECT * from ogrenciler");

        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();

        System.out.println("Stun sayisi "+ rsmd.getColumnCount());
        System.out.println("1.stunun isimleri : "+ rsmd.getColumnName(1));
        System.out.println("2.stunun isimleri : "+ rsmd.getColumnName(2));
        System.out.println("3.stunun isimleri : "+ rsmd.getColumnName(3));
        System.out.println("4.stunun isimleri : "+ rsmd.getColumnName(4));
    }
}
