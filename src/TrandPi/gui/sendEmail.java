/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.gui;

/**
 *
 * @author HP
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.*/

import TrandPi.pojo.CurrentUser;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class MyAuthenticator extends Authenticator{
    private String username,password;
    public MyAuthenticator(String username,String password){
        this.username=username;
        this.password=password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pwdAuth=new PasswordAuthentication(this.username,this.password);        
        return pwdAuth;
    }
    
}
public class sendEmail {
    
    public static void sendMail(String name,double per,String id,String title,String userid) {
       String username = "goswamirishantpuri@gmail.com";
       String password = "frkcjonqssvfzkiy";
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth);                

        try {

            Message message = new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(userid);
            message.setRecipients(
                    Message.RecipientType.TO,
                    recipients
            );
          
            message.setSubject("Notification From SCALIVE Training And Placement Application");
            message.setText("Hello "+name+"\n"+"you got "+per+"% in "+id+"("+title+")"+"\nWarm regards\n\nSCALIVE\nTraining and placement application");
            

            Transport.send(message);
         


        } catch (MessagingException e) {
            e.printStackTrace();
        }
  
    }
    public static void sendMail(String name,String id,String email,String pwd) {
       String username = "goswamirishantpuri@gmail.com";
       String password = "frkcjonqssvfzkiy";
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth);                

        try {

            Message message = new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(email);
            message.setRecipients(
                    Message.RecipientType.TO,
                    recipients
            );
          
            message.setSubject("Login Credentails For Hr From Scalive Training and Placement Application");
            message.setText("Hello "+name+"\n"+"Warm Welcome in SCALIVE Training And Placement Application\n\nYour Login Credentials--\n\nHr Id-"+id+"\nEmail-"+email+"\nPassword-"+pwd+"\n\nWarm Regards\nSCALIVE\nTraining and Placement Application");
            

            Transport.send(message);
         

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    
    }
    public static void sendMail(String hrId,String namePt,String jobId,String jobTitle,String nameHr,String email) {
       String username = "goswamirishantpuri@gmail.com";
       String password = "frkcjonqssvfzkiy";
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth);                

        try {

            Message message = new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(email);
            message.setRecipients(
                    Message.RecipientType.TO,
                    recipients
            );
          
            message.setSubject("Interview Invitation From "+hrId);
            message.setText("Hello "+namePt+"\n\nWarm Welcome from "+hrId+"\n\nJob Description-\n\nJob ID:"+jobId+"\n\nJob Title-"+jobTitle+"\n\nYour interview will be taken by "+nameHr+"\n\nInterview Meeting and Schedule link will be shared soon\n\nWarn Regards\n\nSCALIVE\n\nTraining and Placement Application");
            

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
      
    }
}
