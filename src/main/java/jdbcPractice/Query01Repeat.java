package jdbcPractice;

import java.sql.*;

public class Query01Repeat {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim Driver yukle
        Class.forName("org.postgresql.Driver");
        // 2. Adim : baglanti olustur Datebase'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");
        // 3. Adim Statement olustur.
        Statement st=con.createStatement();
        //4. Adim : ResultSet olustur
        ResultSet veri= st.executeQuery("SELECT * FROM ogrenciler");

        // 5. adim sonuclari al

        while (veri.next()){
            // index kullanarak
        //    System.out.println(veri.getInt(1) + "---" + veri.getString(2)+"---"+ veri.getString(3)+"---"+ veri.getString(4));
            // sutun ismi kullanarak
         //   System.out.println(veri.getInt("okul_no")+"---" +veri.getString("ogrenci_ismi")+"---"+ veri.getString("sinif")+"---"+ veri.getString("cinsiyet"));

            // printf ile souf()
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }
        // class'i kapat
        con.close();
        st.close();
        veri.close();
    }
}
