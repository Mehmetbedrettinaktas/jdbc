package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        // 2. Adim : Database'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/SQL_Batch81","postgres","Mba.,03414");
        // 3. Adim Statement olustur.
        Statement st=con.createStatement();
       //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        // 1. yol offset ve fetch next kullanarak
        String sql1 = "select company,number_of_employees \n" +
                "from companies \n" +
                "order by number_of_employees desc\n" +
                "offset 1 row -- bir tane stun atla\n" +
                "fetch next 1 row only";
       ResultSet result1= st.executeQuery(sql1);
      while (result1.next()){
          System.out.println(result1.getString(1)+" --- "+  result1.getInt("number_of_employees"));
      }
        // 2. yol
        String sql2= "select company,number_of_employees \n" +
                "from companies \n" +
                "where number_of_employees = ( select max(number_of_employees) from companies \n" +
                "where number_of_employees< (select max(number_of_employees) \n" +
                "from companies ))";
            ResultSet result2 = st.executeQuery(sql2);
            while (result2.next()){
                System.out.println(result2.getString("company") + " --- "+ result2.getInt("number_of_employees"));
            }
            con.close();
            st.close();
            result1.close();
            result2.close();
    }
}
