package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query04_Repeat {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        // Statement st=con.createStatement(); bunun yerine PreparedStatement parametre kullanmi daha avantajli ve hafizada daha az yer kapliyor.
        PreparedStatement ps= con.prepareStatement("INSERT into ogrenciler values(?, ?, ?, ?)");
        /*
        PreparedStatement 'in Statement farki veya daha avantajli olma durumlari:
        1 - PreparedStatement daha dinamik islemler yapabiliyoruz
        2 - PreparedStatement hafizada daha az yer kapliyor olmasi iki onemli avtajidir
         */
        // tabloya bir satirlik veri girisi yapiyoruz
        ps.setInt(1,300);
        ps.setString(2, "Ali veli");
        ps.setString(3,"20");
        ps.setString(4,"E");

        ps.executeUpdate();

        System.out.println("Veri girisi yapildi");


    }
}
