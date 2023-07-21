/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techQuizApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import techQuizApp.DBConnection.DBConnection;
import techQuizApp.POJO.RegisterStudentPOJO;

/**
 *
 * @author spsub
 */
public class RegisterStudentDAO {
    private static final Connection CONN = DBConnection.getConnection();
    private static PreparedStatement ps;
    
    public static boolean registerStudent(RegisterStudentPOJO registerStudent) throws SQLException
    {
        ps = CONN.prepareStatement("insert into users values (?,?,?,?)");
        ps.setString(1, getUserId());
        ps.setString(2, registerStudent.getUserID());
        ps.setString(3, String.valueOf(registerStudent.getPassword()));
        ps.setString(4, "Student");
        ResultSet result = ps.executeQuery();
        return result.next();
    }
    
    public static boolean updatePassword(String studentID, char [] oldPassword,char [] newPassword) throws SQLException
    {
        ps = CONN.prepareStatement("update users set password = ? where userid=? and password=?");
        ps.setString(1, String.valueOf(newPassword));
        ps.setString(2, studentID);
        ps.setString(3, String.valueOf(oldPassword));
        ResultSet result = ps.executeQuery();
        return result.next();
    }
    
    public static String getUserId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement ps = conn.createStatement();
        ResultSet result = ps.executeQuery("select count(*) from users");
        if(result.next())
            return result.getString(1);
        return "1";
    }
}
