package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // 1.Adim  DBWork objesini olustur
        DBWork db= new DBWork();
        // Connection fonksiyonumu dcagir.
      Connection con= db.connect_to_db("SQL_Batch81","postgres","Mba.,03414");

      // Yeni table olusturma methodunu cagir
        db.createTable(con,"employees");




    }
}
