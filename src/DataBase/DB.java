package DataBase;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private final String url = "jdbc:postgresql://localhost/";
    private final String user = "postgres";
    private final String password = "nurdaulet";
    String username,password1;
    private static DB uniqueDB;
    private Connection conn;
    private DB(){}
    public static DB getInstance(){
        if(uniqueDB == null){
            uniqueDB = new DB();
        }
        return uniqueDB;
    }
    public Connection getConn(){
        if(conn == null){
            conn = connect();
        }
        return conn;
    }
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url+"Observer", user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    public boolean login_user() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "SELECT * FROM users where username='"+username+"' and password='"+password1+"'";
        try (PreparedStatement pst = getConn().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                user1=rs.getString("username");
                user_pas=rs.getString("password");
                if(user1.equals(username) && user_pas.equals(password1)) {
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
//            pst.setString(1,username);
//            pst.setString(2, password1);
//            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public int routes(String A, String B) {
        String sql = "Select * from routes where city1='"+A+"'and city2='"+B+"';";
        try( PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()){
            while (rs.next()) {
                return rs.getInt("distance");
            }
        }catch (Exception e){
            System.out.println(e);

        }
        return 0;
    }
}
