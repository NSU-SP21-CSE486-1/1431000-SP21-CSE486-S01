package com.mahmud.android.CPC_JobApp.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "student_info")


public class StudentInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final Integer studentID;

    @ColumnInfo(name = "name")
    private String studentName;

    @ColumnInfo(name = "age")
    private Integer studentAge;

    @ColumnInfo(name = "school")
    private String schoolName;

    @ColumnInfo(name = "department")
    private String department;

    @ColumnInfo(name = "dob")
    private Date dob;

    @ColumnInfo(name = "phone")
    private Integer phone;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nid")
    private Integer nid;

    //Present Address
    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "district")
    private String district;

    @ColumnInfo(name = "poffice")
    private String poffice;

    @ColumnInfo(name = "pstation")
    private String pstation;

    @ColumnInfo(name = "pcode")
    private String pcode;

    @ColumnInfo(name = "houseno")
    private String houseno;

    @ColumnInfo(name = "roadno")
    private String roadno;


  public StudentInfo(@NonNull Integer studentID
          , String studentName
          , @NonNull Integer studentAge, String schoolName, String department,
                     Date dob, Integer phone, Integer nid,
                     String country, String district, String poffice, String pstation, String pcode, String houseno, String roadno ){

                        this.studentID = studentID;
                        this.studentName = studentName;
                        this.studentAge = studentAge;
                        this.schoolName = schoolName;
                        this.department = department;
                        this.dob = dob;
                        this.phone = phone;
                        this.nid = nid;
                        this.country = country;
                        this.district = district;
                        this.poffice = poffice;
                        this.pstation = pstation;
                        this.pcode = pcode;
                        this.houseno = houseno;
                        this.roadno = roadno;
  }
//Setter Methods
  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public void setStudentAge(Integer studentAge) {
    this.studentAge = studentAge;
  }

  public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

  public void setDepartment(String department) { this.department = department; }

  public void setDob(Date dob) { this.dob = dob; }

  public void setPhone(Integer phone) { this.phone = phone; }

  public void setNid(Integer nid) { this.nid = nid; }

  public void setCountry(String country) { this.country = country; }

  public void setDistrict(String district) { this.district = district; }

  public void setPoffice(String poffice) { this.poffice = poffice; }

  public void setPstation(String pstation) { this.pstation = pstation; }

  public void setPcode(String pcode) { this.pcode = pcode; }

  public void setHouseno(String houseno) { this.houseno = houseno; }



  //Getter Methods
  @NonNull
  public Integer getStudentID() {
    return studentID;
  }

  public String getStudentName() {
    return studentName;
  }

  public Integer getStudentAge() {
    return studentAge;
  }

  public String getSchoolName() { return schoolName; }

  public String getDepartment() { return department; }

  public Date getDob() { return dob; }

  public Integer getPhone() { return phone; }

  public Integer getNid() { return nid; }

  public String getCountry() { return country; }

  public String getDistrict() { return district; }

  public String getPoffice() { return poffice; }

  public String getPstation() { return pstation; }

  public String getPcode() { return pcode; }

  public String getHouseno() { return houseno; }

  public String getRoadno() { return roadno; }
}
