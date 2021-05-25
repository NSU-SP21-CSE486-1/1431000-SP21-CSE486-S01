package com.mahmud.android.CPC_JobApp.datasource.local.room.entity;

public class JobInfo {
    String addPosition, addSalary, jobCategory, addDetail;

    public JobInfo(String addPosition, String addSalary, String jobCategory, String addDetail){
        this.addPosition = addPosition;
        this.addSalary = addSalary;
        this.jobCategory = jobCategory;
        this.addDetail = addDetail;
    }


    public String getAddPosition() {
        return addPosition;
    }
    public void setAddPosition(String addPosition) {
        this.addPosition = addPosition;
    }

    public String getAddSalary() {
        return addSalary;
    }
    public void setAddSalary(String addSalary) {
        this.addSalary = addSalary;
    }

    public String getJobCategory() {
        return jobCategory;
    }
    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getAddDetail() {
        return addDetail;
    }
    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

}
