   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.dao;

import TrandPi.dbutil.DbConnection;
import TrandPi.pojo.JobPojo;
import TrandPi.pojo.ResultPojo;
import TrandPi.pojo.hrPojo;
import TrandPi.pojo.participantPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class hrDAO {
    public static int getNewHrId()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(hrid) from hr");
        int hrId=101;
        rs.next();
        String strid=rs.getString(1);
        if(strid!=null)
        {  
            String id=strid.substring(3);
            hrId=Integer.parseInt(id)+1;
        }
        return hrId;
    }
    public static int addNewHr(hrPojo hr)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid from users where userid=?");
        ps.setString(1, hr.getUserId());
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            return -1;
        }
        ps=conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
        ps.setString(1,hr.getUserId());
        ps.setString(2, hr.getHrId());
        ps.setString(3, hr.getHrName());
        ps.setString(4,hr.getPassword());
        ps.setString(5,hr.getType());
        ps.setString(6,"Y");
        int x=ps.executeUpdate();
        int y=0;
        if(x==1)
        {
            ps=conn.prepareStatement("insert into hr values(?,?,?,?)");
            ps.setString(1,hr.getHrId());
            ps.setString(2, hr.getPhone());
            ps.setString(3, hr.getCompanyName());
            ps.setString(4, hr.getProfession());
            y=ps.executeUpdate();
        }
        return y;
    }
    public static List <hrPojo>getAllHr()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select hr.hrid,users.userid,users.name,hr.phone,hr.companyname from hr,users where hr.hrid=users.id and users.active='Y' order by hr.hrid");
        List<hrPojo>allHrList=new ArrayList<>();
        while(rs.next())
        {
            hrPojo obj=new hrPojo();
            obj.setHrId(rs.getString(1));
            obj.setUserId(rs.getString(2));
            obj.setHrName(rs.getString(3));
            obj.setPhone(rs.getString(4));
            obj.setCompanyName(rs.getString(5));
            allHrList.add(obj);
        }
        return allHrList;
    }
    public static String getCompanyNameById(String hrId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select companyname from hr where hrid=?");
        ps.setString(1, hrId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }
    public static List<ResultPojo>HrseeResultStudent()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select users.name,results.participantid,results.jobid,results.percentage,users.userid,jobs.jobtitle from jobs,users,results where users.id=results.participantid and users.active='Y' and jobs.jobid=results.jobid");
         List<ResultPojo> student=new ArrayList<>();
         while(rs.next()){
            ResultPojo res=new ResultPojo();
            res.setName(rs.getString(1));
            res.setpId(rs.getString(2));
            res.setJobId(rs.getString(3));
            res.setPercentage(rs.getDouble(4));
            res.setUserid(rs.getString(5));
            res.setJobTitle(rs.getString(6));
            student.add(res);
         }
         return student;
    }
    public static List<JobPojo>hrGetOpenAllAvailablejob()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select jobid,jobtitle,tags,status from jobs where status=-1");
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
}
