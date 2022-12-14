package jdbc_JavaDatabaseConnectivity;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim Driver yukle
        Class.forName("org.postgresql.Driver");
        // 2. Adim : baglanti olustur Datebase'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Batch81", "postgres", "1234");
        Statement st = con.createStatement(); // execute calistirmak demek
        //1. Örnek:  region id'si 1 olan "country name" değerlerini çağırın.
        String sql1 = "SELECT country_name FROM countries WHERE region_id = 1"; // SELECT dedigimiz icin herhabgi bir ´degisiklik olmuyor
        boolean r1 = st.execute(sql1); //
        System.out.println(r1);//true yada false verir. çünkü data çağırma işlemi yaptık.

        //REcordları görmek için executeQuery() methodu kullanmalıyız.
        ResultSet result1 = st.executeQuery(sql1);

        while (result1.next()) {

            System.out.println(result1.getString("country_name")); // stun isimleri

        }

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        String sql2 = "SELECT country_id, country_name FROM countries WHERE region_id > 2";
        ResultSet result2 = st.executeQuery(sql2); // executeQuery() karsida data cekmek icin kullaniliyor
        while (result2.next()) {

            System.out.println(result2.getString("country_id") + "-->" + result2.getString("country_name"));

        }

        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

        String sql3 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet result3 = st.executeQuery(sql3);

        while (result3.next()) {
            System.out.println(result3.getInt("company_id") + "--" + result3.getString("company") + "--" + result3.getInt("number_of_employees"));
        }
        con.close();
        st.close();
    }
}
