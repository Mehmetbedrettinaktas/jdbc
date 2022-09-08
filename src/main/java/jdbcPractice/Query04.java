package jdbcPractice;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim Driver yukle
        Class.forName("org.postgresql.Driver");
        // 2. Adim : baglanti olustur Datebase'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");
        // 3. Adim Statement olustur.
        // Statement st=con.createStatement(); bunun yerine PreparedStatement parametre kullanmi daha avantajli ve hafizada daha az yer kapliyor.
        PreparedStatement ps= con.prepareStatement("INSERT into ogrenciler values(?, ?, ?, ?)");
        ps.setInt(1,200);
        ps.setString(2,"Veli Can");
        ps.setString(3,"12");
        ps.setString(4, "E");

        ps.executeUpdate();
        System.out.println("Veri girisi yapildi.");







    }
}
