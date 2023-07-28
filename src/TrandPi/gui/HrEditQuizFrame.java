/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TrandPi.gui;

import TrandPi.dao.questionDAO;
import TrandPi.pojo.QuestionPojo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class HrEditQuizFrame extends javax.swing.JFrame {
private int counter=0;
private String jobId;
private List<QuestionPojo>questionlist;
private QuestionPojo currentquestion;
    /** Creates new form HrEditQuizFrame */
    public HrEditQuizFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
     public HrEditQuizFrame(String jobId) {
         this();
         this.jobId=jobId;
         lblqno3.setText(""+counter+1);
         loadQuestionPaper();
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblqno3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtque3 = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtoption13 = new javax.swing.JTextField();
        txtoption14 = new javax.swing.JTextField();
        txtoption15 = new javax.swing.JTextField();
        txtoption16 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jcchoosecorrectoption3 = new javax.swing.JComboBox<>();
        btnprevious3 = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btndiscardpaper = new javax.swing.JButton();
        btnsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(243, 246, 254));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TrandPi/gui/World-Map.png"))); // NOI18N

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TrandPi/gui/transparent logo.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Que.");

        lblqno3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtque3.setColumns(20);
        txtque3.setFont(new java.awt.Font("Serif", 2, 24)); // NOI18N
        txtque3.setRows(5);
        jScrollPane4.setViewportView(txtque3);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("Options-");

        jLabel36.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel36.setText("Option-1");

        jLabel37.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel37.setText("option-2");

        jLabel38.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel38.setText("option-3");

        jLabel39.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel39.setText("option-4");

        txtoption13.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N

        txtoption14.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N

        txtoption15.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N

        txtoption16.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jLabel40.setText("Correct Option-");

        jcchoosecorrectoption3.setFont(new java.awt.Font("Serif", 2, 18)); // NOI18N
        jcchoosecorrectoption3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE CORRECT OPTION", "option1", "option2", "option3 ", "option4" }));

        btnprevious3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnprevious3.setText("Previous");
        btnprevious3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevious3ActionPerformed(evt);
            }
        });

        btnnext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btndiscardpaper.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btndiscardpaper.setText("Discard Paper");
        btndiscardpaper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndiscardpaperActionPerformed(evt);
            }
        });

        btnsubmit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel33)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblqno3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcchoosecorrectoption3, 0, 269, Short.MAX_VALUE)
                            .addComponent(txtoption13)
                            .addComponent(txtoption15))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtoption14, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtoption16, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnprevious3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btndiscardpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblqno3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtoption13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtoption14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtoption15, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtoption16, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcchoosecorrectoption3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel40))
                        .addGap(64, 64, 64)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprevious3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndiscardpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadQuestionPaper()
    {
        try{
            questionlist=questionDAO.getQuestionPaperByJobid(jobId);
            shownextQuestionInFrame();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Db Error","Error",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
   
    private void btnprevious3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevious3ActionPerformed
    if (validateInput()) {
            setQuestionInList();
            --counter;
            if (counter==-1) {
                counter=questionlist.size()-1;
            }
            lblqno3.setText(""+(counter+1));
            shownextQuestionInFrame();
        }
        else{
            JOptionPane.showMessageDialog(null, "Plzz fill all the fields","EMPTY FIELDS",JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnprevious3ActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        if (validateInput()) {
            setQuestionInList();
            ++counter;
            if (counter==questionlist.size()) {
                counter=0;
            }
            lblqno3.setText(""+(counter+1));
            shownextQuestionInFrame();
        }
        else{
            JOptionPane.showMessageDialog(null, "Plzz fill all the fields","EMPTY FIELDS",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnnextActionPerformed

    private void btndiscardpaperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndiscardpaperActionPerformed

    }//GEN-LAST:event_btndiscardpaperActionPerformed

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
       if (validateInput()) {
            setQuestionInList();
           try{
               boolean result=questionDAO.editQuestionPaper(questionlist);
               if (result) {
                   JOptionPane.showMessageDialog(null, "Question paper added succesfully","SUCCES",JOptionPane.INFORMATION_MESSAGE);
                   new HrChooseJobForEditingQuizFrame();
                   this.dispose();
               }
           }
           catch(SQLException ex)
           {
               JOptionPane.showMessageDialog(null, "DB Error in Quiz","DB ERROR",JOptionPane.ERROR_MESSAGE);
               ex.printStackTrace();
           }
        }
        else{
            JOptionPane.showMessageDialog(null, "Plzz fill all the fields","EMPTY FIELDS",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnsubmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HrEditQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HrEditQuizFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndiscardpaper;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnprevious1;
    private javax.swing.JButton btnprevious2;
    private javax.swing.JButton btnprevious3;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox<String> jcchoosecorrectoption;
    private javax.swing.JComboBox<String> jcchoosecorrectoption1;
    private javax.swing.JComboBox<String> jcchoosecorrectoption2;
    private javax.swing.JComboBox<String> jcchoosecorrectoption3;
    private javax.swing.JLabel lblqno;
    private javax.swing.JLabel lblqno1;
    private javax.swing.JLabel lblqno2;
    private javax.swing.JLabel lblqno3;
    private javax.swing.JTextField txtoption1;
    private javax.swing.JTextField txtoption10;
    private javax.swing.JTextField txtoption11;
    private javax.swing.JTextField txtoption12;
    private javax.swing.JTextField txtoption13;
    private javax.swing.JTextField txtoption14;
    private javax.swing.JTextField txtoption15;
    private javax.swing.JTextField txtoption16;
    private javax.swing.JTextField txtoption2;
    private javax.swing.JTextField txtoption3;
    private javax.swing.JTextField txtoption4;
    private javax.swing.JTextField txtoption5;
    private javax.swing.JTextField txtoption6;
    private javax.swing.JTextField txtoption7;
    private javax.swing.JTextField txtoption8;
    private javax.swing.JTextField txtoption9;
    private javax.swing.JTextArea txtque;
    private javax.swing.JTextArea txtque1;
    private javax.swing.JTextArea txtque2;
    private javax.swing.JTextArea txtque3;
    // End of variables declaration//GEN-END:variables
 private boolean validateInput()
    {
        if (txtque3.getText().equals("")||txtoption13.getText().equals("")||txtoption14.getText().equals("")||txtoption15.getText().equals("")||txtoption16.getText().equals("")||jcchoosecorrectoption3.getSelectedIndex()==0) {
            return false;
        }
        return true;
    }
    private void shownextQuestionInFrame() {
        currentquestion=questionlist.get(counter);
        txtque3.setText(currentquestion.getQuestion());
        txtoption13.setText(currentquestion.getOption1());
        txtoption14.setText(currentquestion.getOption2());
        txtoption15.setText(currentquestion.getOption3());
        txtoption16.setText(currentquestion.getOption4());
        jcchoosecorrectoption3.setSelectedIndex(currentquestion.getCorrectoption());  
    }

    private void setQuestionInList() {
      currentquestion.setQuestion(txtque3.getText().trim());
      currentquestion.setOption1(txtoption13.getText().trim());
      currentquestion.setOption2(txtoption14.getText().trim());
      currentquestion.setOption3(txtoption15.getText().trim());
      currentquestion.setOption4(txtoption16.getText().trim());
      currentquestion.setCorrectoption(jcchoosecorrectoption3.getSelectedIndex());
      questionlist.set(counter, currentquestion);
    }

}