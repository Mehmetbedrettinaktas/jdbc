package jdbc;

import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        Java'da methodlar return type sahibi olsa da, void olsa da methods olarak adlandirilir.
        SQL'de ise data return ediyorsa "function" denir. Return yapmiyorsa "procedure" diye adlandirilir.

         */
        // 1. Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");
        // 2. Adim : Database'e baglan
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/SQL_Batch81","postgres","Mba.,03414");
        // 3. Adim Statement olustur.
        Statement st=con.createStatement();

        //-- 1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.
        //1. Adim: Fonksion kodunu yaz
        String sql1="CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC, y NUMERIC) \n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql \n" +
                "As\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN x+y;\n" +
                "\n" +
                "END\n" +
                "$$";
        //2. Adim: Fonksionu calistir
        st.execute(sql1);

        // 3. Adim Fonksiyonu cagir.
       CallableStatement cst1= con.prepareCall("{? = call toplamaF(?, ?)}");

       //4. Adim: Return icin registerOutParameter() methoddunu, parametreler icin set() methodlarindan uygun olanlari
       cst1.registerOutParameter(1,Types.NUMERIC);
       cst1.setInt(2,15);
       cst1.setInt(3,25);

        //5. Adim : Calistirmak icin execute() methoddunu kullan.
        cst1.execute();

        // 6. Adim: Sonucu cagirmak icin return data tipine gore "get" methodlaarindan uygun olani kullan
        System.out.println(cst1.getBigDecimal(1));


        System.out.println("***************************");
        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        //1. Adim: Fonksion kodunu yaz
        String sql2="CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC) \n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql \n" +
                "As\n" +
                "$$\n" +
                "BEGIN\n" +
                "\n" +
                "RETURN 3.14*r*r*h/3;\n" +
                "\n" +
                "END\n" +
                "$$";
        //2. Adim: Fonksionu calistir
        st.execute(sql2);

        // 3. Adim Fonksiyonu cagir.
        CallableStatement cst2= con.prepareCall("{? = call koniHacmi(?, ?)}");

        //4. Adim: Return icin registerOutParameter() methoddunu, parametreler icin set() methodlarindan uygun olanlari
        cst2.registerOutParameter(1,Types.NUMERIC);
        cst2.setInt(2,3);
        cst2.setInt(3,5);

        //5. Adim : Calistirmak icin execute() methoddunu kullan.
        cst2.execute();

        // 6. Adim: Sonucu cagirmak icin return data tipine gore "get" methodlaarindan uygun olani kullan
        System.out.println(cst2.getBigDecimal(1));

    }
}
