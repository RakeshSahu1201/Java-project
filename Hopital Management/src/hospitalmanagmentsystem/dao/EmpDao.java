/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.dao;

import hospitalmanagmentsystem.dbutil.DBConnection;
import hospitalmanagmentsystem.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class EmpDao {

    public static boolean addEmployee(EmpPojo e) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setString(1, e.getEmpid());
        ps.setString(2, e.getEmpname());
        ps.setString(3, e.getJob());
        ps.setDouble(4, e.getSal());
        int x = ps.executeUpdate();
        if (x > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static String getNewId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select count(*) from employees");
        
        
        //If it is for the first employee id generation
        rs.next();
        if (rs.getInt(1) == 0) {
            int id = 101;
            id = id + rs.getInt(1);
            String sr = "E" + id;
            System.out.println(sr);
            return sr;
        }
        
        //This is for all employee id generation except for the first employee.
        rs=st.executeQuery("Select MAX(emp_id) from employees");
        String empId = null;
        if(rs.next()){
            //id=id+rs.getInt(1);
            System.out.println(rs.getString(1).substring(1));
            try{
                int id = Integer.parseInt(rs.getString(1).substring(1))+1;
                empId = "E"+id;
            }
            catch(NumberFormatException nfe){
                System.out.println("Employee can't be generated.");
                nfe.printStackTrace();
                return empId;
            }
        }
        
        return empId;
        
    }
    
    public static boolean deleteEmployee(String empId) throws SQLException {
//        if(!deleteBranch(empId)){
//            System.out.println("does not exist/can not delete the employee and its branches of doctor or receptionist.");
//        }
        deleteBranch(empId);
        PreparedStatement ps = DBConnection.getConnection().prepareStatement("delete from employees where emp_id=?");
        ps.setString(1, empId);
        return (ps.executeUpdate() != 0);        
    }
    
    public static void deleteBranch(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select emp_name,emp_departement from employees where emp_id=?");
        ps.setString(1, empId);
        ResultSet rs =  ps.executeQuery();
        String empName;
        String empDepartement;
        if(rs.next()){
            empName = rs.getString(1);
            empDepartement = rs.getString(2);
            if(empDepartement.equalsIgnoreCase("receptionist")){
                UserDao.deleteUser(empName);
                ReceptionistDao.deleteReceptionistByName(empName);
            }
            else if(empDepartement.equalsIgnoreCase("doctor")){
                UserDao.deleteUser(empName);
                DoctorsDao.deleteDoctorByName(empName);
            }
        }
    }

    public static HashMap<String, String> getReceptionist() throws SQLException {
        Connection conn = DBConnection.getConnection();
        //String qry = "Select emp_id,emp_name from employees where emp_departement='RECEPTIONIST' ORDER BY emp_id ASC";
        String qry = "select emp_id,emp_name from employees where emp_departement='RECEPTIONIST' and emp_name not in (select user_name from users where user_type='RECEPTIONIST') order by emp_id ASC ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        HashMap<String, String> receptionists = new HashMap();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);            
            receptionists.put(id, name);
        }
        return receptionists;
    }

    public static HashMap<String,String> getDoctors() throws SQLException {
        Connection conn = DBConnection.getConnection();
        //String qry = "Select emp_id,emp_name from employees where emp_departement='DOCTOR' ORDER BY emp_id ASC";
        String qry = "select emp_id,emp_name from employees where emp_departement='DOCTOR' and emp_name not in (select user_name from users where user_type='DOCTOR') order by emp_id ASC ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        HashMap<String,String> doctors = new HashMap<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            
            doctors.put(id,name);
        }
        return doctors;
    }
    
    public static EmpPojo getEmployeeById(String empId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from employees where emp_id=?");
        ps.setString(1, empId);
        ResultSet rs = ps.executeQuery();
        EmpPojo emp = null;
        if (rs.next()) {
            emp = new EmpPojo();
            emp.setEmpid(rs.getString("emp_id"));
            emp.setEmpname(rs.getString("emp_name"));
            emp.setJob(rs.getString("emp_departement"));
            emp.setSal(rs.getDouble("emp_salary"));
            return emp;
        }
        return emp;
    }
    
    public static ArrayList<String> getAllEmployeesId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry = "Select emp_id from employees ORDER BY emp_id ASC";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<String> empIds=new ArrayList<>();
        while(rs.next()){
            String empId=rs.getString(1);
            empIds.add(empId);
        }
        return empIds;
        
    }
    
    public static boolean updateEmployee(EmpPojo employee)throws SQLException
    {
        if(!checkBranch(employee))
            return false;
        
        
        updateBranch(employee);
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update employees set EMP_NAME=?,EMP_DEPARTEMENT=?,EMP_SALARY=? where EMP_ID=?");
        ps.setString(1,employee.getEmpname());
        ps.setString(2,employee.getJob());
        ps.setDouble(3,employee.getSal());
        ps.setString(4, employee.getEmpid());
        int x=ps.executeUpdate();
        return x != 0;
        
    }
    
    private static boolean checkBranch(EmpPojo employee) throws SQLException{
        
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select count(*) from users where user_name=?");
        ps.setString(1,employee.getEmpname());
        ResultSet rs = ps.executeQuery();
        rs.next();
        //System.out.println(rs.getInt(1));
        return rs.getInt(1)==0;
    }
    
    
    public static void updateBranch(EmpPojo employee) throws SQLException {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select emp_name from employees where EMP_ID=?");
        ps.setString(1,employee.getEmpid());
        ResultSet rs = ps.executeQuery();
        String prevName = "";
        if(rs.next()){
            prevName = rs.getString(1);
            
            if(employee.getJob().equalsIgnoreCase("receptionist")){
                ReceptionistDao.updateReceptionistName(employee.getEmpname(),prevName);
            }
            else if(employee.getJob().equalsIgnoreCase("doctor")){
                DoctorsDao.updateDoctorName(employee.getEmpname(),prevName);
            }  
        }
             
    }
    
    
    public static ArrayList<EmpPojo> getAllEmployeesDetails() throws SQLException {
        Connection conn = DBConnection.getConnection();
        String qry = "Select * from employees ORDER BY emp_id ASC";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(qry);
        ArrayList<EmpPojo> employees = new ArrayList<>();
        while (rs.next()) {
            EmpPojo obj = new EmpPojo();

            obj.setEmpid(rs.getString("emp_id"));
            obj.setEmpname(rs.getString("emp_name"));
            obj.setJob(rs.getString("emp_departement"));
            obj.setSal(rs.getDouble("emp_salary"));
            employees.add(obj);

        }
        return employees;

    }
    
    
    

//    private static boolean checkBranch(EmpPojo employee) throws SQLException{
//        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select emp_departement from employees where EMP_ID=?");
//        ps.setString(1,employee.getEmpid());
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        String prevDept = rs.getString(1);
//        if(employee.getJob().equalsIgnoreCase(prevDept))
//            return true;
//        
//        
//        ps=DBConnection.getConnection().prepareStatement("select user_type from users where user_name=?");
//        ps.setString(1,employee.getEmpname());
//        rs = ps.executeQuery();
//        if(rs.next())
//        {
//            String dept = rs.getString(1);
//            return employee.getJob().startsWith(dept);
//        }
//        return false;
//    }
    
}
