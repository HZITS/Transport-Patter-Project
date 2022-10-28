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
        String sql = "SELECT * FROM users where username='"+username+"' and password='"+password1+"' and status='available'";
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
    public boolean login_admin(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "SELECT * FROM admins where username='"+username+"' and password='"+password1+"'";
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
    public boolean create_user() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your username");
        username=scan.nextLine();
        System.out.println("Write your password");
        password1=scan.nextLine();
        String user1,user_pas;
        String sql = "insert into users(username,password) values('"+username+"', '"+password1+"');";
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            return true;
//            pst.setString(1,username);
//            pst.setString(2, password1);
//            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;

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
    public void get_users(){
        String sql="Select * from users";
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;


    }
    public void get_users_by_name(String name){
        String sql = "Select * from users where username='"+name+"' limit 1;";
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } ;


    }
    public boolean  checkUser(String name){
        boolean HasUser=false;
        String sql = "Select * from users where username='"+name+"' limit 1;";
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                HasUser=true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HasUser;
    }
    public void deleteUser(int id){
        String sql = "update users set status='deleted' where user_id="+id;
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            System.out.println("User deleted");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void banUser(int id){
        String sql = "update users set status='ban' where user_id="+id;
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            System.out.println("User banned");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unBanUser(int id){
        String sql = "update users set status='available' where user_id="+id;
        try{
            Statement statement = getConn().createStatement();
            statement.executeUpdate(sql);
            System.out.println("User unbanned");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void restoreUser(int id){
        String sql = "update users set status='available' where user_id="+id;
        try(PreparedStatement pst=conn.prepareStatement(sql)) {
            System.out.println("User restored");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
