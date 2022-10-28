import DataBase.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
/*    private final String url = "jdbc:postgresql://localhost/design_pattern";
    private final String user = "postgres";
    private final String password = "Aisha2016";
*/
/*    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }*/
    public static void main(String [] args){
        DB.getInstance().getConn();
        Program program = new Program();
        program.start();
    }
}
