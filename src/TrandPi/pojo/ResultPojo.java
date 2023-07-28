/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrandPi.pojo;

/**
 *
 * @author HP
 */
public class ResultPojo extends UserPojo {

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSelectedbyHr() {
        return selectedbyHr;
    }

    public void setSelectedbyHr(String selectedbyHr) {
        this.selectedbyHr = selectedbyHr;
    }
     private String pId;
     private String jobId;
     private double percentage;
     private String selectedbyHr;    
     private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
