/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aftab
 */
public class DBConnection {
     private static Connection conn;

    static
    {

        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver loaded successfully");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//BLACK-PEARL:1521/XE","project","java");
            System.out.println("connection open successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public static Connection getConnection()
    {
        return conn;
    }

    public static void closeConnection()
    {
        if (conn!=null)
        {

            try
            {
                conn.close();
                System.out.println("conn close successfully");
            }
            catch (SQLException e)
            {
                e.printStackTrace();

            }
        }
    }
    
}
