package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05_Repeat {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        Statement st=con.createStatement();
        // PreparedStatement ps= con.prepareStatement("INSERT into ogrenciler values(?, ?, ?, ?)");

        // Soru: ogrenciler tablosuna yeni bir kayit ekleyin(600, 'Sena Can',12, 'K')
      //  int s1= st.executeUpdate("insert into ogrenciler values (600, 'Sena Can',12, 'K') ");
        // System.out.println(s1+ " satir databas'e eklendi");

        // SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (601, 'Sena Can', 12, 'K'), (602, 'Sena Can', 12, 'K'), (603, 'Sena Can', 12, 'K')

        /*
        // 1. Yol
        String [] veri={ "INSERT into ogrenciler values (601, 'Sena Can', 12, 'K')",
                     "INSERT into ogrenciler values (602, 'Sena Can', 12, 'K')",
                     "INSERT into ogrenciler values (603, 'Sena Can', 12, 'K')",};
        int count=0;
        for (String each:veri) {
           count=count + st.executeUpdate(each);
        }
        System.out.println(count +" satir eklendi");

         */

        // 2. Yoll

        String [] veri2={ "INSERT into ogrenciler values (604, 'Sena Can', 12, 'K')",
                "INSERT into ogrenciler values (605, 'Sena Can', 12, 'K')",
                "INSERT into ogrenciler values (606, 'Sena Can', 12, 'K')",};

        for (String each:veri2) {
            st.addBatch(each); // Yukardaki datalarin hepsini birlestiriyor

        }
        st.executeBatch(); // Datalari tek seferde gonderiyor



    }

}
