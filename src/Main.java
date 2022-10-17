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
        Scanner sc=new Scanner(System.in);
        DB db = DB.getInstance();
        Navigator navigator = new Navigator();
        System.out.println("Welcome to our program");
        System.out.println("Please verify or create an account");
        System.out.println("1.Login");
        System.out.println("2.Create");
        int option=sc.nextInt();
        if(option==1){
            if(db.login_user()) navigator.customize();

        }else if(option==2) db.create_user();

    }
}
