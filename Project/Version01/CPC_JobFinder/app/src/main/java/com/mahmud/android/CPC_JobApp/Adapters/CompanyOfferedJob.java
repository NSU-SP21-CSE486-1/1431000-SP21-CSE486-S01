package com.mahmud.android.CPC_JobApp.Adapters;

public class CompanyOfferedJob {

    int offeredJobImage;
    String offeredJobPosition, offeredJobSalary, offeredJobDescription;


    public CompanyOfferedJob(int offeredJobImage, String offeredJobPosition, String offeredJobSalary, String offeredJobDescription){
        this.offeredJobImage = offeredJobImage;
        this.offeredJobPosition = offeredJobPosition;
        this.offeredJobSalary = offeredJobSalary;
        this.offeredJobDescription = offeredJobDescription;
    }

    public int getOfferedJobImage() {
        return offeredJobImage;
    }

    public void setOfferedJobImage(int offeredJobImage) {
        this.offeredJobImage = offeredJobImage;
    }

    public String getOfferedJobPosition() {
        return offeredJobPosition;
    }

    public void setOfferedJobPosition(String offeredJobPosition) {
        this.offeredJobPosition = offeredJobPosition;
    }

    public String getOfferedJobSalary() {
        return offeredJobSalary;
    }

    public void setOfferedJobSalary(String offeredJobSalary) {
        this.offeredJobSalary = offeredJobSalary;
    }

    public String getOfferedJobDescription() {
        return offeredJobDescription;
    }

    public void setOfferedJobDescription(String offeredJobDescription) {
        this.offeredJobDescription = offeredJobDescription;
    }
}
