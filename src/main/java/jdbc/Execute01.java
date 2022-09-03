package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        // 2. Adim : Database'e baglan
     Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/SQL_Batch81","postgres","Mba.,03414");
        // 3. Adim Statement olustur.
       Statement st=con.createStatement(); // Bunu calistirmak icin olusturulan konteyner

       // 4. Adim: Query calistir.
        // 1. Ornek : "workers" adinda bir table olusturup "worker_id,worker_name,worker_salary" stunlari ekleyin

         String sql1= "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
       boolean result= st.execute(sql1);
        System.out.println(result); // false return yapar, cunku data cagrilmadi.

        //2.Örnek: Table'a worker_address sütunu ekleyerel alter(degistir) yapın.

        String sql2= "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);


        //3.ornek: Drop workers table
       String sql3="DROP TABLE workers";
       st.execute(sql3);
       // 5. Adim : Baglanti ve statement'i kapat
        con.close();
        st.close();
    }
}
