package com.mahmud.cpc_jobportal.viewmodel;

import com.mahmud.cpc_jobportal.ui.StudentLoginActivity;

public class StudentsRecord {

    public String name_reg, id_reg, email_reg;

    public StudentsRecord(){


    }

    public StudentsRecord(String name_reg, String id_reg, String email_reg, String phone_reg) {
        this.name_reg = name_reg;
        this.id_reg = id_reg;
        this.email_reg = email_reg;
    }
}
