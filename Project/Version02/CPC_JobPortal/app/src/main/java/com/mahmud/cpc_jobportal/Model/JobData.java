package com.mahmud.cpc_jobportal.Model;

public class JobData {
    String postion, company, description, salary;
    String id, date;

    public JobData(){

    }

    public JobData(String postion, String company, String description, String salary, String id, String date) {
        this.postion = postion;
        this.company = company;
        this.description = description;
        this.salary = salary;
        this.id = id;
        this.date = date;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
