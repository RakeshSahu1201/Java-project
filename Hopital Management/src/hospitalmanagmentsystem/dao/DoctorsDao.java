/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.DoctorPojo;
import hospitalmanagmentsystem.pojo.DoctorsP;
import hospitalmanagmentsystem.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorsDao {

    public static boolean addDoctor(DoctorsP d) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
        long ms1 = d.getDoj().getTime();

        java.sql.Date d1 = new java.sql.Date(ms1);

        System.out.println(d.getDoctor_id());
        ps.setString(1, d.getDoctor_id());
        ps.setString(2, d.getDoctor_name());
        ps.setString(3, d.getEmail());
        ps.setLong(4, d.getContact());
        ps.setString(5, d.getQualification());
        ps.setString(6, d.getGender());
        ps.setDate(7, d1);

        return (ps.executeUpdate() != 0);

    }

    public static boolean deleteDoctors(String doctorId) throws SQLException {
        
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1, doctorId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        UserDao.deleteUser(rs.getString(1));
        
        ps = DBConnection.getConnection().prepareStatement("delete from doctors where doctor_id=?");
        ps.setString(1, doctorId);
        
        return (ps.executeUpdate() != 0);
    }
    
    public static boolean deleteDoctorByName(String doctorName) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("delete from doctors where doctor_name=?");
        ps.setString(1, doctorName);
        return (ps.executeUpdate() != 0);
    }

    public static ArrayList<DoctorPojo> getAllDoctorsDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select * from DOCTORS ORDER BY doctor_id ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<DoctorPojo> doctor = new ArrayList<>();
        while (rs.next()) {
            DoctorPojo obj = new DoctorPojo();
            
            obj.setDoctorId(rs.getString("doctor_id"));
            obj.setDoctorName(rs.getString("doctor_name"));
            obj.setEmailId(rs.getString("email_id"));
            obj.setContactNo(rs.getString("contact_no"));           
            obj.setQualification(rs.getString("qualification"));
            obj.setGender(rs.getString("gender"));
            obj.setSpecialist(rs.getString("specialist"));
            doctor.add(obj);

        }
        return doctor;

    }

    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select count(*) from doctors");
        rs.next();
        if(rs.getInt(1) == 0){
            int id = 101;
            id = id + rs.getInt(1);
            String sr = "DOC" + id;
            return sr;
        }
        
        rs = st.executeQuery("Select MAX(doctor_id) from doctors");
        String doctorId = null;
        if(rs.next()){
            System.out.println(rs.getString(1).substring(3));
            try{
                int id = Integer.parseInt(rs.getString(1).substring(3))+1;
                doctorId = "DOC"+id;
            }
            catch(NumberFormatException nfe){
                System.out.println("doctor can't be generated.");
                nfe.printStackTrace();
                return doctorId;
            }
        }
        
        return doctorId;
    }

    public static ArrayList<String> getAllDoctorsId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select doctor_id from doctors ORDER BY doctor_id ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<String> obj = new ArrayList<>();
        while (rs.next()) {
            String doctor_id = rs.getString(1);
            obj.add(doctor_id);
        }
        return obj;

    }

    public static boolean addDoctors(UserPojo user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "insert into users values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(qry);
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUserType().toUpperCase());
        int x = ps.executeUpdate();
        if (x > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addDoctors(DoctorPojo d) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
        ps.setString(1, d.getDoctorId());
        ps.setString(2, d.getDoctorName());
        ps.setString(3, d.getEmailId());
        ps.setString(4, d.getContactNo());
        ps.setString(5, d.getQualification());
        ps.setString(6, d.getGender());
        ps.setString(7, d.getSpecialist());
        return (ps.executeUpdate() != 0);
    }
    
    
    public static String getDoctorNameById(String doctorId) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select doctor_name from doctors where doctor_id=?");
        ps.setString(1, doctorId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    
    
    public static boolean updateDoctorName(String newName,String prevName) throws SQLException {
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("update doctors set doctor_name=? where doctor_name=?");
        ps.setString(1, newName);
        ps.setString(2, prevName);
        int rs = ps.executeUpdate();
        return rs>0;
    }
}
