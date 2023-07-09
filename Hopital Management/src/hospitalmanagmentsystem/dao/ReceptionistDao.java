/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.EmpPojo;
import hospitalmanagmentsystem.pojo.ReceptionistPojo;
import hospitalmanagmentsystem.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Soft1
 */
public class ReceptionistDao {

    public static ArrayList<String> getAllReceptionistId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select receptionist_id from receptionists ORDER BY receptionist_id ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<String> obj = new ArrayList<>();
        while (rs.next()) {
            String receptionistId = rs.getString(1);
            obj.add(receptionistId);
        }
        return obj;

    }

    public static boolean deleteReceptionist(String receptionistId) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select receptionist_name from receptionists where receptionist_id=?");
        ps.setString(1, receptionistId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserDao.deleteUser(rs.getString(1));
              
        ps = DBConnection.getConnection().prepareStatement("delete from receptionists where receptionist_id=?");
        ps.setString(1, receptionistId);
        return (ps.executeUpdate() != 0);
    }
    
    public static boolean deleteReceptionistByName(String receptionistName) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("delete from receptionists where receptionist_name=?");
        ps.setString(1, receptionistName);
        return (ps.executeUpdate() != 0);
    }

    public static ArrayList<ReceptionistPojo> getAllReceptionistDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select * from receptionists ORDER BY receptionist_id ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<ReceptionistPojo> recep = new ArrayList<>();
        while (rs.next()) {
            ReceptionistPojo obj = new ReceptionistPojo();
            obj.setReceptionistId(rs.getString("receptionist_id"));
            obj.setReceptionistName(rs.getString("receptionist_name"));
            obj.setGender(rs.getString("gender"));
            recep.add(obj);

        }
        return recep;

    }
    
    public static ReceptionistPojo getReceptionistDetailsById(String receptionistId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select * from receptionists where receptionist_id=?";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,receptionistId);
        ResultSet rs = ps.executeQuery();
        ReceptionistPojo receptionist = null;
        while (rs.next()) {
            receptionist =new ReceptionistPojo();
            receptionist.setReceptionistId(rs.getString("receptionist_id"));
            receptionist.setReceptionistName(rs.getString("receptionist_name"));
            receptionist.setGender(rs.getString("gender"));
        }
        return receptionist;

    }
    
    public static UserPojo getReceptionistDetailsByName(String receptionistName) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select * from users where user_name=? and user_type='RECEPTIONIST'";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1,receptionistName);
        ResultSet rs = ps.executeQuery();
        UserPojo receptionistUser = new UserPojo();
        while (rs.next()) {
            receptionistUser.setLoginId(rs.getString("login_id"));
            receptionistUser.setPassword(rs.getString("password"));
            receptionistUser.setUserName(rs.getString("user_name"));
            receptionistUser.setUserType(rs.getString("user_type"));
        }
        return receptionistUser;

    }
    
    
    public static boolean addReceptionist(ReceptionistPojo receptionist) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into RECEPTIONISTS values(?,?,?)");
        ps.setString(1, receptionist.getReceptionistId());
        ps.setString(2, receptionist.getReceptionistName());
        ps.setString(3, receptionist.getGender());
        int x = ps.executeUpdate();
        return x > 0;
    }
    
    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select count(*) from receptionists");
        
        rs.next();
        if (rs.getInt(1) == 0) {
            int id = 101;
            id = id + rs.getInt(1);
            String sr = "RECP" + id;
            return sr;
        }
        
        rs=st.executeQuery("Select MAX(receptionist_id) from receptionists");
        String receptionistId = null;
        if(rs.next()){
            //id=id+rs.getInt(1);
            System.out.println(rs.getString(1).substring(1));
            try{
                int id = Integer.parseInt(rs.getString(1).substring(4))+1;
                receptionistId = "RECP"+id;
            }
            catch(NumberFormatException nfe){
                System.out.println("receptionist can't be generated.");
                nfe.printStackTrace();
                return receptionistId;
            }
        }
        
        return receptionistId;
        
        
    }
    
    
    public static boolean addReceptionist(UserPojo user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        String qry = "insert into users values(?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getLoginId());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getUserType().toUpperCase());
        int x=ps.executeUpdate();
        return x>0;
    }
    
    public static boolean updateReceptionist(ReceptionistPojo receptionist)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement
        ("update receptionists set gender=? where RECEPTIONIST_ID=?");
        ps.setString(1,receptionist.getGender());
        ps.setString(2,receptionist.getReceptionistId());
        int x=ps.executeUpdate();
        return x != 0;
        
    }
    
    public static boolean updateReceptionist(UserPojo receptionist)throws SQLException
    {
        System.out.println("inside the update receptionist data : "+receptionist);
        PreparedStatement ps=DBConnection.getConnection().prepareStatement
        ("update users set password=?,login_id=? where user_type=? and user_name=?");
        ps.setString(1,receptionist.getPassword());
        ps.setString(2,receptionist.getLoginId());
        ps.setString(3,receptionist.getUserType());
        ps.setString(4,receptionist.getUserName());
        int x=ps.executeUpdate();
        return x != 0;
        
    }
    
    public static boolean updateReceptionistName(String newName,String prevName) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("update receptionists set receptionist_name=? where receptionist_name=?");
        ps.setString(1, newName);
        ps.setString(2, prevName);
        int rs = ps.executeUpdate();
        return rs>0;
    }
    
}
