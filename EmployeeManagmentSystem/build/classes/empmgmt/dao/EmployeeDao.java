/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeeDao {
    
    public static Boolean addEmployee(employee emp)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into Employee values(?,?,?)");
        ps.setInt(1,emp.getEmpno());
        ps.setString(2,emp.getEname());
        ps.setDouble(3,emp.getEsal());
        int result = ps.executeUpdate();
        return result >0;
    }
    public static employee findEmployeeById(int empid)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from Employee where empid=?");
        ps.setInt(1,empid);
        ResultSet rs = ps.executeQuery();
        employee e = null;
        while(rs.next())
        {
            e = new employee();
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setEsal(rs.getFloat(3));
        }
        return e;
    }
    public static ArrayList<employee> getAllEmployees()throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from Employee");
        ArrayList<employee> emplist = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            employee e = new employee();
            e.setEmpno(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setEsal(rs.getFloat(3));
            emplist.add(e);
        }
        return emplist;
    }
    public static Boolean updateEmployeeById(employee e)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update employee set empname=?,empsal=? where empid=?");
        ps.setString(1,e.getEname());
        ps.setDouble(2,e.getEsal());
        ps.setInt(3,e.getEmpno());        
        int result = ps.executeUpdate();
        return result>0;
    }
    public static Boolean deleteEmployeeById(int empid)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Delete from Employee where empid=?");
        ps.setInt(1,empid);
        int result = ps.executeUpdate();
        return result>0;
    }
}
