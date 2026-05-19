package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KelasKoneksi {
    
    private static Connection conDB = null;
    
    public static Connection koneksiDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            String url = "jdbc:mysql://localhost:3306/db_kampus_resky"
                       + "?useSSL=false"
                       + "&serverTimezone=UTC"
                       + "&useUnicode=true"
                       + "&characterEncoding=UTF-8"
                       + "&characterEncoding=UTF-8";
            String user = "root";
            String pass = "";
            
            conDB = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Sukses!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conDB;
    }

    public static void main(String[] args) {
        koneksiDB();
    }
}
