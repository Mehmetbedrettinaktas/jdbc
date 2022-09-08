package jdbcPractice;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim Driver yukle
        Class.forName("org.postgresql.Driver");
        // 2. Adim : baglanti olustur Datebase'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");
        // 3. Adim Statement olustur.
        Statement st=con.createStatement();
        //4. Adim : ResultSet olustur
        ResultSet result1= st.executeQuery("SELECT * FROM ogrenciler");

        // 5. Adim : Sonuclari al
        while (result1.next()){
            // index kullanarak
            System.out.println(result1.getInt(1)+"---"+ result1.getString(2)
                    +"---"+ result1.getString(3)+"---"+result1.getString(4));

            System.out.println();

            // stun ismi kullanarak getir
            System.out.println(result1.getInt("okul_no")+ " --- "+ result1.getString("ogrenci_ismi")
                    +result1.getString("sinif")+"---"+ result1.getString("cinsiyet"));

            System.out.printf("%-6d %-15.15s %-8s %-8s\n", result1.getInt(1), result1.getString(2), result1.getString(3), result1.getString(4));
        }
        con.close();
        st.close();
    }
}
