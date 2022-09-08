package jdbc_JavaDatabaseConnectivity;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        // 2. Adim : Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");
        // 3. Adim Statement olustur.
        Statement st = con.createStatement();
        // 1. Örnek: Prepared statement kullanarak company adı IBM olan
        // number_of_employees değerini 9999 olarak güncelleyin.

        // 1.Adim : Prepared statement query'isini olustur
        String sql1 = "update companies set number_of_employees = ? where company = ?";

        // 2. Adim: PreparedStatement objesini olustur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        // 3. Adim :set...() methodlari ile soru isaretleri icin deger gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        // 4.Adim Execute query
        int updateRowsayisi = pst1.executeUpdate();
        System.out.println(updateRowsayisi + " satir guncelendi.");
        String sql2 = "SELECT * FROM companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1) + " --- " + result1.getString(2) + " --- " + result1.getInt(3));
        }
        // Google icin degisiklik
        pst1.setInt(1, 17000);
        pst1.setString(2, "GOOGLE");


        int updateRowsayisi2 = pst1.executeUpdate();
        System.out.println(updateRowsayisi2 + " satir guncelendi.");
        String sql3 = "SELECT * FROM companies";
        ResultSet result3 = st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getInt(1) + " --- " + result3.getString(2) + " --- " + result3.getInt(3));
        }
        //  //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        System.out.println("*********");
        readData(con,"companies");

    }


    // Bir tablonun istenlen dasini prapared statement ile cagirmak icin kullanilan method
    public static void readData(Connection con, String tabelName) {
        try {

            String query = String.format("SELECT * FROM %s", tabelName); // Format() methodu dinamik String olusturmak icin kullanilir

            Statement statement = con.createStatement();
            // SQL query'yi calistir
            ResultSet rs = statement.executeQuery(query); // Datayi cagirip ResulSet konteynerina koyuyoruz
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " --- " + rs.getString(2) + " --- " + rs.getInt(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}