package DataBase;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private final String url = "jdbc:postgresql://localhost/designpattern";
    private final String user = "postgres";
    private final String password = "Aisha2016";

    String username,password1;

    public boolean login_user() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM users where username='"+username+"' and password='"+password1+"'");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                user1=rs.getString("username");
                user_pas=rs.getString("password");
                if(user1==username && user_pas==password1) {
                    return true;
                }

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(
                    DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    public void create_user() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("insert into users(username,password) values('"+username+"','"+password1+"');");
             ResultSet rs = pst.executeQuery()) {
            pst.setString(1,username);
            pst.setString(2, password1);
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
}
