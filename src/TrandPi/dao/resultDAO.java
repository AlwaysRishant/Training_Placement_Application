 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.dao;

import TrandPi.dbutil.DbConnection;
import TrandPi.pojo.ResultPojo;
import TrandPi.pojo.participantJobPojo;
import TrandPi.pojo.participantResultPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class resultDAO {
    public static boolean applyForJob(ResultPojo result)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from results where participantid=? and jobid=?");
        ps.setString(1, result.getpId());
        ps.setString(2, result.getJobId());
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            return false;
        }
        ps=conn.prepareStatement("insert into results values(?,?,?,?)");
        ps.setString(1, result.getpId());
        ps.setString(2, result.getJobId());
        ps.setDouble(3, result.getPercentage());
        ps.setString(4,result.getSelectedbyHr());
        return 1==ps.executeUpdate();
    }
    public static List<participantJobPojo> getAllAppliedJobs(String participantId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select jobs.jobid,jobs.jobtitle,companyname,tags from jobs,results,hr where jobs.jobid=results.jobid and jobs.hrid=hr.hrid and participantid=? and percentage=-1");
        ps.setString(1, participantId);
        List<participantJobPojo> allAppliedJobsList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {    
            participantJobPojo pj=new participantJobPojo();
            pj.setJobId(rs.getString(1));
            pj.setJobTitle(rs.getString(2));
            pj.setCompanyname(rs.getString(3));
            pj.setTags(rs.getString(4));
            allAppliedJobsList.add(pj);
        }
        return allAppliedJobsList;
    }
    public static boolean setResult(ResultPojo result)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update results set percentage=? where participantid=? and jobid=?"); 
        ps.setDouble(1,result.getPercentage());
        ps.setString(2, result.getpId());
        ps.setString(3, result.getJobId());
        return 1==ps.executeUpdate();
    }
    public static List<participantResultPojo> getAllcompletedJobs(String participantId)throws SQLException
    {
          Connection conn=DbConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("select jobs.jobid,jobs.jobtitle,hr.companyname,jobs.tags,results.percentage from jobs,hr,results where jobs.jobid=results.jobid and jobs.hrid=hr.hrid and results.percentage!=-1 and results.participantid=?");
          ps.setString(1, participantId);
          ResultSet rs=ps.executeQuery();
          List<participantResultPojo> allResultList=new ArrayList<>();
          while(rs.next())
          {
              participantResultPojo result=new participantResultPojo();
              result.setJobId(rs.getString(1));
              result.setJobTitle(rs.getString(2));
              result.setCompanyname(rs.getString(3));
              result.setTags(rs.getString(4));
              result.setPercentage(rs.getDouble(5));
              allResultList.add(result);
          }
          return allResultList;
    }
    public static boolean setSelectedByHr(String jobId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update results set selectedbyhr='Y' where jobid=?"); 
        ps.setString(1, jobId);
        return 1==ps.executeUpdate();
    }
}
