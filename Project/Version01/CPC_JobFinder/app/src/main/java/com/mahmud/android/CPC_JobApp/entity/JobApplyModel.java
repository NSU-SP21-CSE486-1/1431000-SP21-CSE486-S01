package com.mahmud.android.CPC_JobApp.entity;

public class JobApplyModel {

    int applyImage;
    String salary, appliedJob, applyNumber;

    public JobApplyModel(int applyImage, String salary, String appliedJob, String applyNumber){

        this.applyImage = applyImage;
        this.salary = salary;
        this.appliedJob = appliedJob;
        this.applyNumber = applyNumber;

    }

    public int getApplyImage() {
        return applyImage;
    }

    public void setApplyImage(int applyImage) {
        this.applyImage = applyImage;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAppliedJob() {
        return appliedJob;
    }

    public void setAppliedJob(String appliedJob) {
        this.appliedJob = appliedJob;
    }

    public String getApplyNumber() {
        return applyNumber;
    }

    public void setApplyNumber(String applyNumber) {
        this.applyNumber = applyNumber;
    }



}
