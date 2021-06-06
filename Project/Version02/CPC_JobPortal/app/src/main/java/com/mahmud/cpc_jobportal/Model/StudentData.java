package com.mahmud.cpc_jobportal.Model;

import java.util.Date;

public class StudentData {
    String id, name, department, present_address, phone, dob;


    public StudentData(){

    }

    public StudentData(String id, String name, String department, String present_address, String phone, String dob) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.present_address = present_address;
        this.phone = phone;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPresent_address() {
        return present_address;
    }

    public void setPresent_address(String present_address) {
        this.present_address = present_address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
