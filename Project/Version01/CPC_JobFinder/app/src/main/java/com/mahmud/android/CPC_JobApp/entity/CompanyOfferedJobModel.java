package com.mahmud.android.CPC_JobApp.entity;

public class CompanyOfferedJobModel {

    int offeredJobImage;
    String offeredPositionName, offeredSalary, offeredJobDescription;

    public CompanyOfferedJobModel(int offeredJobImage, String offeredPositionName, String offeredSalary, String offeredJobDescription){
        this.offeredJobImage = offeredJobImage;
        this.offeredPositionName = offeredPositionName;
        this.offeredSalary = offeredSalary;
        this.offeredJobDescription = offeredJobDescription;
    }


    public int getOfferedJobImage() { return offeredJobImage; }
    public String getOfferedPositionName() {
        return offeredPositionName;
    }
    public String getOfferedSalary() {
        return offeredSalary;
    }
    public String getOfferedJobDescription() {
        return offeredJobDescription;
    }



    public void setOfferedJobImage(int offeredJobImage){
        this.offeredJobImage = offeredJobImage;}

    public void setOfferedPositionName(String offeredPositionName) {
        this.offeredPositionName = offeredPositionName; }

    public void setOfferedSalary(String offeredSalary) {
        this.offeredSalary = offeredSalary;
    }
    public void setOfferedJobDescription(String offeredJobDescription) {
        this.offeredJobDescription = offeredJobDescription;
    }

}
