/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DbConnection {
    public static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-9KGN5MS:1521/XE","tnp", "project"); 
            JOptionPane.showMessageDialog(null,"connect succesfully to DB");
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in driver loading"+ex.getMessage());
            ex.printStackTrace();
        }   
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in dropening the connection to DB"+ex.getMessage());
            ex.printStackTrace();
        }   
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void CloseConnection()
    {
        try{
            conn.close();
            JOptionPane.showMessageDialog(null,"Disconnect succesfully");
        }
        catch(SQLException ex)
        {
             JOptionPane.showMessageDialog(null,"Error in Disconnect to DB"+ex.getMessage());
             ex.printStackTrace();
        }
    }
}