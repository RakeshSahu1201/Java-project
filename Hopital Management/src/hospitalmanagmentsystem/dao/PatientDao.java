/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.PatientPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aftab
 */
public class PatientDao {
    public static boolean addPatient(PatientPojo p)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patients values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getPatientId());
        ps.setString(2, p.getFirstName());
        ps.setString(3, p.getLastName());
        ps.setInt(4, p.getAge());
        ps.setString(5, p.getGender());
        ps.setString(6, p.getMarriedStatus());
        ps.setString(7, p.getAddress());
        ps.setString(8, p.getCity());
        ps.setString(9,p.getMno());
        ps.setDate(10,p.getDate());
        ps.setInt(11,p.getOtp());
        ps.setString(12, p.getOpd());
        ps.setString(13,p.getDoctorId());
        ps.setString(14, p.getAptStatus());
        
        
        return (ps.executeUpdate()!=0);
        
    }
    public static boolean deletePatient(String patientId)throws SQLException
    {
       PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from patients where patient_id=?");
       ps.setString(1, patientId);
       return (ps.executeUpdate()!=0);
    }
    public static boolean updatePatient(PatientPojo p)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update patients set first_name=?,last_name=?,age=?,gender=?,m_status=?,address=?,city=?,mobile_no=?,p_date=?,otp=?,opd=?,doctor_id=? where patient_id=?");
        System.out.println(p.getPatientId());
        ps.setString(1,p.getFirstName());
        ps.setString(2,p.getLastName());
        ps.setInt(3,p.getAge());
        ps.setString(4,p.getGender());
        ps.setString(5,p.getMarriedStatus());
        ps.setString(6,p.getAddress());
        ps.setString(7,p.getCity());
        ps.setString(8,p.getMno());
        ps.setDate(9,p.getDate());
        ps.setInt(10,p.getOtp());
        ps.setString(11,p.getOpd());
        ps.setString(12,p.getDoctorId());
        ps.setString(13,p.getPatientId());
        int x=ps.executeUpdate();
        if (x==0)
        
            return false;
        else
        
            return true;
        
      
        
        
    }
   
    public static PatientPojo getAllData()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry = "Select * from patients ORDER BY patient_id ASC";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        PatientPojo obj=new PatientPojo();
        while(rs.next()){
            
              obj.setPatientId(rs.getString("patient_id"));
              obj.setFirstName(rs.getString("first_name"));
              obj.setLastName(rs.getString("last_name"));
              obj.setAge(rs.getInt("age"));
              obj.setOpd(rs.getString("opd"));
              obj.setGender(rs.getString("gender"));
              obj.setMarriedStatus(rs.getString("m_status"));
              obj.setDate(rs.getDate("p_date"));
              obj.setAddress(rs.getString("address"));
              obj.setCity(rs.getString("city"));
              obj.setMno(rs.getString("mobile_no"));
              obj.setDoctorId(rs.getString("doctor_id"));
              obj.setAptStatus(rs.getString("status"));
             
              
        }
        return obj;
        
    }
    public static PatientPojo getPatientDetailsById(String patientId)throws SQLException
    {
      PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from patients where patient_id=?");
      ps.setString(1, patientId);
      ResultSet rs=ps.executeQuery();
      PatientPojo obj=null;
      while(rs.next()){
                obj = new PatientPojo();
              obj.setPatientId(rs.getString("patient_id"));
              obj.setFirstName(rs.getString("first_name"));
              obj.setLastName(rs.getString("last_name"));
              obj.setAge(rs.getInt("age"));
              obj.setOpd(rs.getString("opd"));
              obj.setGender(rs.getString("gender"));
              obj.setMarriedStatus(rs.getString("m_status"));
              obj.setDate(rs.getDate("p_date"));
              obj.setAddress(rs.getString("address"));
              obj.setCity(rs.getString("city"));
              obj.setMno(rs.getString("mobile_no"));
              obj.setDoctorId(rs.getString("doctor_id"));
              obj.setAptStatus(rs.getString("status"));
             
              
        }
        return obj;
    }
    public static ArrayList<PatientPojo> getAllPatientDetails()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry = "Select * from patients ORDER BY patient_id ASC";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<PatientPojo> patients=new ArrayList<>();
        while(rs.next()){
              PatientPojo obj=new PatientPojo();
              obj.setPatientId(rs.getString("patient_id"));
              obj.setFirstName(rs.getString("first_name"));
              obj.setLastName(rs.getString("last_name"));
              obj.setAge(rs.getInt("age"));
              obj.setOpd(rs.getString("opd"));
              obj.setGender(rs.getString("gender"));
              obj.setMarriedStatus(rs.getString("m_status"));
              obj.setDate(rs.getDate("p_date"));
              obj.setAddress(rs.getString("address"));
              obj.setCity(rs.getString("city"));
              obj.setMno(rs.getString("mobile_no"));
              obj.setDoctorId(rs.getString("doctor_id"));
              obj.setAptStatus(rs.getString("status"));
              patients.add(obj);
             
              
        }
        return patients;
    }
    public static ArrayList<String> getAllPatientId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry = "Select * from patients ORDER BY patient_id ASC";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<String> obj=new ArrayList<>();
        while(rs.next()){
            String patient_id=rs.getString(1);
            obj.add(patient_id);
        }
        return obj;
        
    }
    
    public static ArrayList<String> getAllPatientDoctorId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry = "Select DISTINCT doctor_id from patients ORDER BY doctor_id ASC";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<String> obj=new ArrayList<>();
        while(rs.next()){
            String patient_id=rs.getString(1);
            obj.add(patient_id);
        }
        return obj;
        
    }
    
     public static String getNewId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        //if it is the first patient id
        
        ResultSet rs = st.executeQuery("Select count(*) from patients");
        rs.next();
        if(rs.getInt(1) == 0){
            int id = 101;
            id = id + rs.getInt(1);
            String sr = "P" + id;
            return sr;
        }
        
        
        
        rs=st.executeQuery("Select MAX(patient_id) from patients");
        String patientId = null;
        if(rs.next()){
            //id=id+rs.getInt(1);
            System.out.println(rs.getString(1).substring(1));
            try{
                int id = Integer.parseInt(rs.getString(1).substring(1))+1;
                patientId = "P"+id;
            }
            catch(NumberFormatException nfe){
                System.out.println("patient can't be generated.");
                nfe.printStackTrace();
                return patientId;
            }
        }
        
        return patientId;
    }
   public static PatientPojo getDetailsByOtp(String patientId,int otp)throws SQLException
   {
      PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from patients where patient_id=? and otp=?");
      
      ps.setString(1,patientId);
      ps.setInt(2,otp);
      ResultSet rs=ps.executeQuery();
      PatientPojo obj=new PatientPojo();
      if(rs.next()){
                
              obj.setOtp(rs.getInt("otp"));
              System.out.println(rs.getInt("otp"));
              obj.setPatientId(rs.getString("patient_id"));
              obj.setFirstName(rs.getString("first_name"));
              obj.setLastName(rs.getString("last_name"));
              obj.setAge(rs.getInt("age"));
              obj.setOpd(rs.getString("opd"));
              obj.setGender(rs.getString("gender"));
              obj.setMarriedStatus(rs.getString("m_status"));
              obj.setDate(rs.getDate("p_date"));
              obj.setAddress(rs.getString("address"));
              obj.setCity(rs.getString("city"));
              obj.setMno(rs.getString("mobile_no"));
              obj.setDoctorId(rs.getString("doctor_id"));
              obj.setAptStatus(rs.getString("status"));
              return obj;
      }
      else
      {
          return null;
      }
     
   }
    
}
