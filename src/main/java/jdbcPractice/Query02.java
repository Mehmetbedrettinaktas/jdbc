package jdbcPractice;

import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");

        Statement st=con.createStatement();

        ResultSet data= st.executeQuery("SELECT * FROM ogrenciler where cinsiyet='E'");

        //SORU: Öğrenciler tablosundaki Erkek öğrencileri listeleyiniz?
        while (data.next()) {
            System.out.println(data.getInt(1) + " " + data.getString(2) +
                    " " + data.getString(3)+ " " + data.getString(4));
        }

    }
}
