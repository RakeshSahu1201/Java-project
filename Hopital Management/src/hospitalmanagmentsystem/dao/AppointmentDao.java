package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.AppointmentPojo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDao {
   public static boolean addAppointment(AppointmentPojo apt) throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into appointments values (?,?,?,?,?,?,?)");

        ps.setString(1,apt.getPatientId());
        ps.setString(2,apt.getPatientName());
        ps.setString(3,apt.getStatus());
        ps.setString(4,apt.getOpd());
        ps.setString(5,apt.getAppointmentDate());
        ps.setString(6,apt.getDoctorName());
        ps.setString(7,apt.getMobileNo());
        
        return (ps.executeUpdate() != 0);
       
   }
   
   
   public static boolean updateAppointment(AppointmentPojo apt) throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().
                prepareStatement("update appointments set patient_name=?, status=?, opd=?, date_time=?, doctor_name=?, mobile_no=? where patient_id=?");

        ps.setString(7,apt.getPatientId());
        ps.setString(1,apt.getPatientName());
        ps.setString(2,apt.getStatus());
        ps.setString(3,apt.getOpd());
        ps.setString(4,apt.getAppointmentDate());
        ps.setString(5,apt.getDoctorName());
        ps.setString(6,apt.getMobileNo());
        
        return (ps.executeUpdate() != 0);
       
   }
   
   public static ArrayList<AppointmentPojo> getData(String u) throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().
                prepareStatement("SELECT patient_id,first_name,opd FROM patients WHERE doctor_id=? ORDER BY patient_id ASC");

        ps.setString(1,u);
        ResultSet rs=ps.executeQuery();

        ArrayList<AppointmentPojo> ap=new ArrayList<>();
        while(rs.next())
        {
            String p_id=rs.getString(1);
            String p_name=rs.getString(2);
            String opd=rs.getString(3);

            AppointmentPojo p=new AppointmentPojo(p_id,p_name,opd);
            ap.add(p);
        }   
       
       
        return ap;
       
   }
   
   
   public static ArrayList<AppointmentPojo> getConformAppointmentsByDoctorName(String doctorName)throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select patient_id,patient_name,opd,date_time from appointments where doctor_name=? and status='CONFORM' ORDER BY patient_id ASC");
        ps.setString(1,doctorName);
        ResultSet rs=ps.executeQuery();
        ArrayList<AppointmentPojo> appointments = new ArrayList<>();
        while(rs.next())
        {
            AppointmentPojo ap = new AppointmentPojo();
            ap.setPatientId(rs.getString(1));
            ap.setPatientName(rs.getString(2));
            ap.setOpd(rs.getString(3));
            ap.setAppointmentDate(rs.getString(4));
            appointments.add(ap);
        }
        return appointments;
    }
   
   
   public static ArrayList<AppointmentPojo> getAppointmentsByDoctorName(String doctorName)throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select patient_id,patient_name,opd,date_time,status,doctor_name,mobile_no from appointments where doctor_Name=? and status='REQUEST' ORDER BY patient_id ASC");
        ps.setString(1,doctorName);
        ResultSet rs=ps.executeQuery();
        ArrayList<AppointmentPojo> appointments = new ArrayList<>();
        while(rs.next())
        {
            AppointmentPojo ap = new AppointmentPojo();
            ap.setPatientId(rs.getString(1));
            ap.setPatientName(rs.getString(2));
            ap.setOpd(rs.getString(3));
            ap.setAppointmentDate(rs.getString(4));
            ap.setStatus(rs.getString(5));
            ap.setDoctorName(rs.getString(6));
            ap.setMobileNo(rs.getString(7));
            appointments.add(ap);
        }
        return appointments;
    }
   
//   public static ArrayList<AppointmentPojo> getAppointmentsByDoctorName(String userName)throws SQLException{
//        PreparedStatement ps = DBConnection.getConnection().prepareStatement("select doctor_id from doctors where doctor_name=?");
//        ps.setString(1,userName);
//        ResultSet rs=ps.executeQuery();
//        String doctorId = "";
//        if(rs.next()){
//            doctorId=rs.getString(1);
//            System.out.println("doctor id is "+doctorId);
//            return getAppointmentsByDoctorId(doctorId);
//        }
//        return null;
//    }
   
   
   public static boolean updateAppointmentsByPatientId(AppointmentPojo appointment)throws SQLException{
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("update appointments set date_time=?,status=? where patient_id=?");
        ps.setString(1,appointment.getAppointmentDate());
        ps.setString(2,appointment.getStatus());
        ps.setString(3,appointment.getPatientId());
        int result = ps.executeUpdate();
        return result != 0;
    }
}
