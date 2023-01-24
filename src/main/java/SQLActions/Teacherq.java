package SQLActions;

import javax.swing.*;
import java.sql.*;

public class Teacherq {
    public static boolean checkForExistingID(String id) {
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";


        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accountsdata ";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("ID").equals(id)){
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return false;
        }
    }

    public static void UpdateStudentData(String grades, String presences, String projectTopic,String id){
        PreparedStatement pst = null;
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/users", "root", "root");
            pst = conn.prepareStatement("UPDATE accountsdata SET grades = ?, presences = ?, projectTopic = ? WHERE id = ?");
            pst.setString(1, grades);
            pst.setString(2, presences);
            pst.setString(3, projectTopic);
            pst.setString(4, id);
            pst.execute();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null, a);
        }
    }

    public static String getStudentsData(String id) {
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";

        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accountsdata ";
            rs=statement.executeQuery(sql);

            while (rs.next()){
                if(rs.getString("id").equals(id)){
                    String allInfo = rs.getString("grades") + "/" + rs.getString("presences") + "/" + rs.getString("projectTopic");
                    return allInfo;
                }
            }
            return "Error";

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return "Error";
        }
    }

    public static String getAllStudents() {
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";
        String allInfo = null;
        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;

        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accounts";
            rs=statement.executeQuery(sql);
            allInfo = "";
            while (rs.next()){
                allInfo += rs.getString("ID") + "~" + rs.getString("Username") + "~" + rs.getString("E_mail") + "~"+ rs.getString("Address") + "~" + "\n";
            }

            return allInfo;

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return "Error";
        }
    }

    public static String getAllStudentsData() {
        String  jdbcURL = "jdbc:mysql://localhost:3307/users";
        String user="root";
        String password="root";
        String allInfo = null;
        Connection connection = null;
        Statement statement=null;
        ResultSet rs=null;

        try {
            connection = DriverManager.getConnection(jdbcURL, user, password);System.out.println("SQL Connected");
            statement=connection.createStatement();

            String sql="SELECT * FROM accountsData";
            rs=statement.executeQuery(sql);
            allInfo = "";
            while (rs.next()){
                    allInfo += rs.getString("id") + "~" + rs.getString("grades") + "~" + rs.getString("presences") + "~"+ rs.getString("projectTopic") + "~" + "\n";
            }



            return allInfo;

        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            return "Error";
        }
    }
}
