package com.mahmud.android.CPC_JobApp.entity;

public class JobInfoModel {
    int addimage;
    String addPosition, addSalary, jobCategory, addDescription;

    public JobInfoModel(String addPosition, String addSalary, String jobCategory, String addDetail){
        this.addPosition = addPosition;
        this.addSalary = addSalary;
        this.jobCategory = jobCategory;
        this.addDescription = addDetail;
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

    public String getAddDescription() {
        return addDescription;
    }
    public void setAddDescription(String addDetail) {
        this.addDescription = addDescription;
    }

}
