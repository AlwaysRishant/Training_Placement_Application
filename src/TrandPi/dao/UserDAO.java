/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.dao;

import TrandPi.dbutil.DbConnection;
import TrandPi.pojo.CurrentUser;
import TrandPi.pojo.JobPojo;
import TrandPi.pojo.ResultPojo;
import TrandPi.pojo.UserPojo;
import TrandPi.pojo.hrPojo;
import TrandPi.pojo.participantJobPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class UserDAO {
    public static boolean validateUser(UserPojo user)throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and type=? and active='Y'");
        ps.setString(1, user.getUserid());
        ps.setString(2,user.getPassword() );
        ps.setString(3, user.getType());
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            CurrentUser.setUserId(rs.getString(1));
            CurrentUser.setId(rs.getString(2));
            CurrentUser.setName(rs.getString(3));
            CurrentUser.setType(rs.getString(5));
            return true;
        }
        return false;
    }
    public static Map<String,hrPojo>getAllHrList()throws SQLException{
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select userid,id,name from users where type='Hr'and Active='Y'");
        Map<String,hrPojo>allHr=new HashMap<>();
        while(rs.next())
        {
            String userid=rs.getString(1);
            String hrid=rs.getString(2);
            String name=rs.getString(3);
            hrPojo obj=new hrPojo();
            obj.setHrId(hrid);
            obj.setHrName(name);
            allHr.put(userid, obj);
                    
        }
        return allHr;
    }
     public static boolean updatePwd(String userid,String password)throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update users set password=?,active='Y' where userid=?");
         ps.setString(1, password);
         ps.setString(2, userid);
         return 1==ps.executeUpdate();
     }
     public static boolean removeUser(String userId)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update users set active='N' where userid=?");
         ps.setString(1, userId);
         return 1==ps.executeUpdate();
     }
     public static boolean checkOldPassword(String pId,String oldpwd)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select * from users where password=? and id=?");
         ps.setString(1,  oldpwd);
         ps.setString(2, pId);
         ResultSet rs=ps.executeQuery();
         return rs.next(); 
     }
     public static boolean updateParticipantPassword(String pId,String pwd)throws SQLException{
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("update users set password=? where id=?");
         ps.setString(1, pwd);
         ps.setString(2, pId);
         return 1==ps.executeUpdate();
     }
     public static List<JobPojo>adminGetAllAvailablejob()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select jobid,jobtitle,tags,status from jobs");
         List<JobPojo> allOpenJobList=new ArrayList<>();
         while(rs.next()){
             JobPojo job=new JobPojo();
             job.setJobId(rs.getString(1));
             job.setJobTitle(rs.getString(2));   
             job.setTags(rs.getString(3));      
             job.setStatus(rs.getInt(4));      
             allOpenJobList.add(job);
         }
         return allOpenJobList;
    }
     public static List<ResultPojo> AdminSeeHrSelectedStudent()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select users.name,results.participantid,results.jobid,results.percentage,results.selectedbyhr from users,results where results.selectedbyhr=users.active and users.id=results.participantid");
         List<ResultPojo> allstuSelByHr=new ArrayList<>();
         while(rs.next()){
             ResultPojo res=new ResultPojo();
             res.setName(rs.getString(1)); 
             res.setId(rs.getString(2));
             res.setJobId(rs.getString(3));
             res.setPercentage(rs.getDouble(4));
             res.setSelectedbyHr(rs.getString(5));
             allstuSelByHr.add(res);
         }
         return allstuSelByHr;
     }
}