/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techQuizApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techQuizApp.DBConnection.DBConnection;
import techQuizApp.POJO.PerformancePOJO;
import techQuizApp.POJO.StudentStore;

/**
 *
 * @author spsub
 */
public class PerformanceDAO {
    private static final Connection CONN = DBConnection.getConnection();
    public static void addPerformance(PerformancePOJO performance) throws SQLException
    {
        PreparedStatement ps = CONN.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1, performance.getUserId());
        ps.setInt(2, performance.getRight());
        ps.setInt(3, performance.getWrong());
        ps.setInt(4, performance.getUnattemped());
        ps.setDouble(5, performance.getPercentage());
        ps.setString(6, performance.getLanguage());
        ps.setString(7, performance.getExamId());
        ps.executeQuery();
    }
    public static ArrayList<PerformancePOJO> getAllData() throws SQLException
    {
        Statement st = CONN.createStatement();
        ResultSet rs = st.executeQuery("select * from performance");
        ArrayList<PerformancePOJO> performanceList = new ArrayList<>();
        while(rs.next())
        {
            PerformancePOJO performance = new PerformancePOJO();
            performance.setUserId(rs.getString(1));
            performance.setRight(rs.getInt(2));
            performance.setWrong(rs.getInt(3));
            performance.setUnattemped(rs.getInt(4));
            performance.setPercentage(rs.getDouble(5));
            performance.setLanguage(rs.getString(6));
            performance.setExamId(rs.getString(7));
            performanceList.add(performance);
        }
        return performanceList;
    }
    public static ArrayList<String> getAllStudentId() throws SQLException
    {
        Statement st = CONN.createStatement();
        ResultSet rs = st.executeQuery("select distinct userid from performance");
        ArrayList<String> studentIdList = new ArrayList<>();
        while(rs.next())
        {
            String studentId = rs.getString(1);
            studentIdList.add(studentId);
        }
        return studentIdList;
    }
    public static ArrayList<String> getAllExamId(String studentId) throws SQLException
    {
        PreparedStatement ps = CONN.prepareStatement("select examid from performance where userid = ?");
        ps.setString(1,studentId);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> examIdList = new ArrayList<>();
        while(rs.next())
        {
            String examId = rs.getString(1);
            examIdList.add(examId);
        }
        return examIdList;
    }
    public static StudentStore getScore(String studentId,String examId) throws SQLException
    {
        PreparedStatement ps = CONN.prepareStatement("select percentage,language from performance where userid = ? and examid =?");
        ps.setString(1,studentId);
        ps.setString(2, examId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        StudentStore studentStore = new StudentStore();
        studentStore.setPercentage(rs.getDouble(1));
        studentStore.setLanguage(rs.getString(2));
        return studentStore;
    }
    
    public static ArrayList<PerformancePOJO> getAStudentScoreCard(String studentId) throws SQLException
    {
        PreparedStatement ps = CONN.prepareStatement("select * from performance where userid = ?");
        ps.setString(1,studentId);
        ResultSet rs = ps.executeQuery();
        ArrayList<PerformancePOJO> performanceList = new ArrayList<>();
        while(rs.next())
        {
            PerformancePOJO performance = new PerformancePOJO();
            performance.setUserId(rs.getString(1));
            performance.setExamId(rs.getString(2));
            performance.setRight(rs.getInt(3));
            performance.setWrong(rs.getInt(4));
            performance.setUnattemped(rs.getInt(5));
            performance.setPercentage(rs.getDouble(6));
            performance.setLanguage(rs.getString(7));
            performanceList.add(performance);
        }
        return performanceList;
    }
}
