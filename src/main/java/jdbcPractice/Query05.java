package jdbcPractice;

import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        Statement st=con.createStatement();  // bunun yerine PreparedStatement parametre kullanmi daha avantajli ve hafizada daha az yer kapliyor.
       // PreparedStatement ps= con.prepareStatement("INSERT into ogrenciler values(?, ?, ?, ?)");

        // Soru: ogrenciler tablosuna yeni bir kayit ekleyin(300, 'Sena Can',12, 'K')
       // int s1 = st.executeUpdate("INSERT into ogrenciler values (301, 'Sena Can',12, 'K')");
       // System.out.println(s1+" Bir satir eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')
        /*
         String[] veri ={ "INSERT into ogrenciler values (400, 'Sena Can',12, 'K')",
                 "INSERT into ogrenciler values (401, 'Sibel Can',12, 'K')",
                 "INSERT into ogrenciler values (402, 'Sevgi Can',12, 'K')"};

         int count=0;
        for (String each:veri) {
          count=count + st.executeUpdate(each);
        }
        System.out.println(count+" satir eklendi");

         */

        // 2. Yoll
        String[] veri ={ "INSERT into ogrenciler values (500, 'Sena Can',12, 'K')",
                        "INSERT into ogrenciler values (501, 'Sibel Can',12, 'K')",
                        "INSERT into ogrenciler values (502, 'Sevgi Can',12, 'K')"};
        for (String each:veri) {
            st.addBatch(each); // Yukardaki datalarin hepsini birlestiriyor
        }
        st.executeBatch();  // Datalari tek seferde gonderiyor

    }
}
