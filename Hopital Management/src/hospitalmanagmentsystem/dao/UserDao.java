/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aftab
 */
public class UserDao {
     public static String validateUser(User user) throws SQLException{
         Connection conn = DBConnection.getConnection();
        String qry = "Select user_name from Users where login_id=? and password=? and user_type=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs=ps.executeQuery();
        String username =null;
        if(rs.next()){
            username=rs.getString(1);
        }
        return username;
    }
     
     
     public static boolean deleteUser(String userName) throws SQLException{
         Connection conn = DBConnection.getConnection();
        String qry = "delete from Users where user_name=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,userName);
        int rs=ps.executeUpdate();
        
        return rs != 0;
    }
    
}
