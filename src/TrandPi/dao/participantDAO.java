/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.dao;

import TrandPi.dbutil.DbConnection;
import TrandPi.pojo.JobPojo;
import TrandPi.pojo.participantPojo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
public class participantDAO {

    public static int getNewParticipantId() throws SQLException {
        Connection conn = DbConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(pid) from userparticipant");
        int pId = 2001;
        rs.next();
        String strid = rs.getString(1);
        if (strid != null) {
            String id = strid.substring(2);
            pId = Integer.parseInt(id) + 1;
        }
        return pId;
    }

    public static int addnewParticipant(participantPojo pt) throws SQLException, FileNotFoundException {
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select userid from users where userid=?");
        ps.setString(1, pt.getUserId().toUpperCase().trim());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return -1;
        }
        ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
        ps.setString(1, pt.getUserId());
        ps.setString(2, pt.getpId());
        ps.setString(3, pt.getName());
        ps.setString(4, pt.getPassword());
        ps.setString(5, pt.getType());
        ps.setString(6, "Y");
        int x = ps.executeUpdate();
        int y = 0;
        if (x == 1) {
            ps = conn.prepareStatement("insert into userparticipant values(?,?,?,?,?)");
            ps.setString(1, pt.getpId());
            ps.setString(2, pt.getPhone());
            ps.setString(3, pt.getSkills());
            ps.setString(4, pt.getQualification());
            File f = pt.getResume();
            InputStream fin = new FileInputStream(f.getPath());
            ps.setBlob(5, fin);
            y = ps.executeUpdate();
        }
        return y;
    }

    public static participantPojo getParticipantbyId(String id) throws SQLException {
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select name,userid,phone from users,userparticipant where users.id=userparticipant.pid and pid=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        participantPojo pt = new participantPojo();
        pt.setName(rs.getString(1));
        pt.setUserId(rs.getString(2));
        pt.setPhone(rs.getString(3));
        return pt;
    }

    public static boolean updateResume(String pId, File resume) throws SQLException, FileNotFoundException {
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update userparticipant set resume=? where pid=?");
        FileInputStream fobj = new FileInputStream(resume);
        ps.setBlob(1, fobj);
        ps.setString(2, pId);
        return ps.executeUpdate() == 1;
    }
     public static List<participantPojo>adminGetAllStudent()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select users.userid,userparticipant.pid,userparticipant.phone,userparticipant.skills,userparticipant.qualification from users,userparticipant where users.id=userparticipant.pid and users.active='Y'");
         List<participantPojo> student=new ArrayList<>();
         while(rs.next()){
            participantPojo pt=new participantPojo();
            pt.setName(rs.getString(1));
            pt.setpId(rs.getString(2));
            pt.setPhone(rs.getString(3));
            pt.setSkills(rs.getString(4));
            pt.setQualification(rs.getString(5));
            student.add(pt);
         }
         return student;
    }
}
