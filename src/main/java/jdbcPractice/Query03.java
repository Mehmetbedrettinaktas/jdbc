package jdbcPractice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        // Statement st=con.createStatement(); daha dinamik oldugu icin PreparedStatement kullaniyoruz
        PreparedStatement ps= con.prepareStatement("SELECT * from ogrenciler");

        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println(rsmd.getColumnCount());

        System.out.println("1.Stunun ismi : "+ rsmd.getColumnName(1));
        System.out.println("2.Stunun ismi : "+ rsmd.getColumnName(2));
        System.out.println("3.Stunun ismi : "+ rsmd.getColumnName(3));
        System.out.println("4.Stunun ismi : "+ rsmd.getColumnName(4));

        System.out.println("1.Stunun Data tipi : " + rsmd.getColumnTypeName(1));
        System.out.println("2.Stunun Data tipi : " + rsmd.getColumnTypeName(2));
        System.out.println("3.Stunun Data tipi : " + rsmd.getColumnTypeName(3));
        System.out.println("4.Stunun Data tipi : " + rsmd.getColumnTypeName(4));

        System.out.println("tablo ismi : "+rsmd.getTableName(2));

    }
}
