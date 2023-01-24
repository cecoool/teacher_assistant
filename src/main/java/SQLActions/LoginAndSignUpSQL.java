package SQLActions;

import javax.swing.*;
import java.sql.*;

public class LoginAndSignUpSQL {

    public static boolean loginChek(String username, String passwordd){
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return false;
        }

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accounts ";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("Username").equals(username) && rs.getString("Password_").equals(passwordd)){
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return false;
        } finally {
            try {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean checkForExistingName(String username) {
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";
        
        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accounts ";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("Username").equals(username)){
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return false;
        }
    }

    public static void createAccount(String Username, String Password_, String E_mail, String Address_){
        String id = null;
        //////////////////// create 1st table
        String sql = "INSERT INTO accounts( Username, Password_, E_mail, Address) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/users", "root", "root");
            pst = conn.prepareStatement(sql);
            pst.setString(1, Username);
            pst.setString(2, Password_);
            pst.setString(3, E_mail);
            pst.setString(4, Address_);
            pst.execute();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
        }

       ///////////////////// get ID from 1st table (to give it to 2nd table)
        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/users", "root", "root");
            statement=connection.createStatement();
            rs=statement.executeQuery("SELECT ID FROM accounts ");

            while (rs.next()){
               id = rs.getString("ID");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
        }

        //////////////////create second table (with id from first)
        sql = "INSERT INTO accountsdata(id, projectTopic) VALUES (?, ?)"; //create 2nd table
        pst = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/users", "root", "root");
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, "Still don't have a topic.");
            pst.execute();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
        }
    }
}
