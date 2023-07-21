/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techQuizApp.GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techQuizApp.DBConnection.DBConnection;

/**
 *
 * @author spsub
 */
public class NewClass {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "Select examid from exam where language = 'C' minus select examid from performance where userid = '102'";
        Statement ps = conn.createStatement();
        
        ResultSet rs = ps.executeQuery(query);
        ArrayList<String> examIdList = new ArrayList<>();
        while(rs.next())
        {
            examIdList.add(rs.getString(1));
        }
        System.out.println(examIdList);
    }
}
