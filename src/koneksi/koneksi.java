package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

public class koneksi {

    public static Connection getConnection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e1) {
                Class.forName("com.mysql.jdbc.Driver"); // driver lama
            }

            String url = "jdbc:mysql://localhost:3306/dicoba"
                       + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Jakarta";
            Connection conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Koneksi berhasil");
            return conn;

        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Connection koneksiDB() {
        return getConnection();
    }
}