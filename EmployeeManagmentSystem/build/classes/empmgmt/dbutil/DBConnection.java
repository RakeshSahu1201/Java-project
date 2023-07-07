package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




public class DBConnection {
    public static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//BLACK-PEARL:1521/XE","project","java");
        }
        catch(ClassNotFoundException cnf)
        {
            JOptionPane.showMessageDialog(null,"Error in connecting to the DB!","Error!",JOptionPane.ERROR_MESSAGE);
            cnf.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in connecting to the DB!","Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(0);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
        conn.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in disconnecting to the DB!"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
