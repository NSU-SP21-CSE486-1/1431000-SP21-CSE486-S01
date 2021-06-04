package com.mahmud.cpc_jobportal.Model;

public class JobData {
    String position, company, description, salary;
    String id, date;


    public JobData(){

    }


    public JobData(String position, String company, String description, String salary, String id, String date) {
        this.position = position;
        this.company = company;
        this.description = description;
        this.salary = salary;
        this.id = id;
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

