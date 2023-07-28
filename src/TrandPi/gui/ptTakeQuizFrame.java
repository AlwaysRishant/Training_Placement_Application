/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.gui;

import TrandPi.dao.questionDAO;
import TrandPi.dao.resultDAO;
import TrandPi.pojo.CurrentUser;
import TrandPi.pojo.QuestionPojo;
import TrandPi.pojo.ResultPojo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ptTakeQuizFrame extends javax.swing.JFrame {
    private String jobId;
    private String jobTitle;
    private int counter=0;
    private List<QuestionPojo> questionList;
    private List<Integer> answerList;
    private QuestionPojo currentquestion;
    private sendEmail mail;
    private int one=0,two=0;
    /**
     * Creates new form ptTakeQuizFrame
     */
    public ptTakeQuizFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        ExamTimer time=new ExamTimer();
        time.start();
        lbl1.setText(one+"");
        lbl2.setText(two+"");
    }
    public ptTakeQuizFrame(String jobId,String jobTitle)        
    {
        this();
        this.jobId=jobId;
        this.jobTitle=jobTitle;
        lbltitle.setText("paper for "+this.jobTitle);
        lblqno.setText(""+(counter+1));
        this.setVisible(true); 
        loadQuestionPaper();   
    }
    private void loadQuestionPaper()
    {
        try{
            questionList=questionDAO.getQuestionPaperByJobid(jobId);
            answerList=new ArrayList<>(questionList.size());
            for (int i = 0; i < questionList.size(); i++) {
                answerList.add(i,0);
            }
            showNextQuestionInFrame();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Db error in Quiz","Error!!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    private void showNextQuestionInFrame()
    {
        currentquestion=questionList.get(counter);
        txtque.setText(currentquestion.getQuestion());
        jrboption1.setText(currentquestion.getOption1());
        jrboption2.setText(currentquestion.getOption2());
        jrboption3.setText(currentquestion.getOption3());
        jrboption4.setText(currentquestion.getOption4());
        int answer=answerList.get(counter);
        switch(answer)
        {
            case 1:
                    jrboption1.setSelected(true);
                   break;
            case 2:
                    jrboption2.setSelected(true);
                   break;
            case 3:
                    jrboption3.setSelected(true);
                   break;
            case 4:
                    jrboption4.setSelected(true);
                   break;       
            default: 
                    buttonGroup1.clearSelection();       
        }
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtque = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblqno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnprevious = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btndiscard = new javax.swing.JButton();
        btnsubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jrboption1 = new javax.swing.JRadioButton();
        jrboption2 = new javax.swing.JRadioButton();
        jrboption3 = new javax.swing.JRadioButton();
        jrboption4 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(243, 246, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\TrandPi\\src\\TrandPi\\gui\\transparent logo.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\TrandPi\\src\\TrandPi\\gui\\World-Map.png")); // NOI18N

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtque.setColumns(20);
        txtque.setRows(5);
        jScrollPane1.setViewportView(txtque);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Que.");

        lblqno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel3.setText("Options -");

        btnprevious.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnprevious.setText("Previous");
        btnprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviousActionPerformed(evt);
            }
        });

        btnnext.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btndiscard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndiscard.setText("Discard Paper");
        btndiscard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndiscardActionPerformed(evt);
            }
        });

        btnsubmit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel5.setText("option-1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel6.setText("option-2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel7.setText("option-3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setText("option-4");

        buttonGroup1.add(jrboption1);
        jrboption1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        buttonGroup1.add(jrboption2);
        jrboption2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        buttonGroup1.add(jrboption3);
        jrboption3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        buttonGroup1.add(jrboption4);
        jrboption4.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        lbl1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel10.setText(":");

        lbl2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel9.setBackground(new java.awt.Color(255, 0, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("* You have only 10 minutes for this quiz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblqno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jrboption1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                            .addComponent(jrboption3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jrboption2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                            .addComponent(jrboption4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnprevious)
                        .addGap(124, 124, 124)
                        .addComponent(btnnext)
                        .addGap(149, 149, 149)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btndiscard)
                        .addGap(101, 101, 101)
                        .addComponent(btnsubmit)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblqno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jrboption1)
                                    .addComponent(jLabel6)
                                    .addComponent(jrboption2))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jrboption3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jrboption4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnprevious)
                            .addComponent(btnnext)
                            .addComponent(btndiscard)
                            .addComponent(btnsubmit)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        int res=validateChooseOption();
        if (res==0) {
            JOptionPane.showMessageDialog(null, "Please select an option first","NO option selected",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.set(counter,res);
        ++counter;
        if (counter==questionList.size()) {
            counter=0;     
        }
        showNextQuestionInFrame();
        lblqno.setText(""+(counter+1));
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
        int res=validateChooseOption();
        if (res==0) {
            JOptionPane.showMessageDialog(null, "Please select an option first","NO option selected",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.set(counter,res);
        -- counter;
        if (counter==-1) {
            counter=questionList.size()-1;     
        }
        showNextQuestionInFrame();
        lblqno.setText(""+(counter+1));
    }//GEN-LAST:event_btnpreviousActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        int res=validateChooseOption();
        if (res==0) {
            JOptionPane.showMessageDialog(null, "Please select an option first","NO option selected",JOptionPane.WARNING_MESSAGE);
            return;
        }
        answerList.set(counter,res);
        double per=getPercentage();
        ResultPojo result=new ResultPojo();
        result.setJobId(jobId);
        result.setpId(CurrentUser.getId());
        if (per<5) {
            per=5.0;
        }
        result.setPercentage(per);
        result.setSelectedbyHr("No");
        try{
            boolean response=resultDAO.setResult(result);
            if (response) {
                sendEmail.sendMail(CurrentUser.getName(),per,jobId,jobTitle,CurrentUser.getUserId());
                JOptionPane.showMessageDialog(null, "You got "+per+"%marks\nAnd Result has been sent to your mail","Result!!",JOptionPane.INFORMATION_MESSAGE);
                new ptViewAllAppliedJobFrame().setVisible(true); 
                this.dispose();
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Db error in take quiz","Error!!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnsubmitActionPerformed

    private void btndiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndiscardActionPerformed
        new ptViewAllAppliedJobFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btndiscardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandlbl1af.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ptTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ptTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ptTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ptTakeQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ptTakeQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndiscard;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnsubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrboption1;
    private javax.swing.JRadioButton jrboption2;
    private javax.swing.JRadioButton jrboption3;
    private javax.swing.JRadioButton jrboption4;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblqno;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextArea txtque;
    // End of variables declaration//GEN-END:variables

    private int validateChooseOption() {
        if (jrboption1.isSelected()) {
            return 1;
        }
        else if (jrboption2.isSelected()) {
            return 2;
        }
        else if (jrboption3.isSelected()) {
            return 3;
        }
        else if (jrboption4.isSelected()) {
            return 4;
        }
        else{
            return 0;
        }
    }
    private double getPercentage()
    {
        int marksObtained=0;
        for (int i = 0; i < questionList.size(); i++) {
            QuestionPojo question=questionList.get(i);
            if (question.getCorrectoption()==answerList.get(i)) {
                ++marksObtained;
            }
        }
        double per=((double)marksObtained/questionList.size())*100;
        return per;
    }
    class ExamTimer extends Thread{
        public void run()
        {
            while(two!=60)
            {
                 try{
                     two++;
                     lbl2.setText(two+"");
                     Thread.sleep(1000);
                      if (two==59) {
                         two=0;
                         one++;
                         lbl1.setText(one+"");
                     }
                     if (one==10 && two==0) {
                         lbl2.setText(two+"");
                         JOptionPane.showMessageDialog(null, "Time out For This Quiz\n\nTry again","TIME OUT",JOptionPane.INFORMATION_MESSAGE);
                         new ptViewAllAppliedJobFrame().setVisible(true);
                         dispose();
                         break;
                     }        
                 }
                 catch(InterruptedException ex)
                 {
                     JOptionPane.showMessageDialog(null,"Exception In Threading","ERROR!",JOptionPane.ERROR_MESSAGE);
                 }
            }
        }    
    }
}