package com.mahmud.cpc_jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class InsertStudentActivity extends AppCompatActivity {

    private EditText id, name, department, present_address, phone;
    Date dob;

    private Button addStudent;

    private FirebaseAuth mAuth;
    private DatabaseReference mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        id = findViewById(R.id.student_id);
        name = findViewById(R.id.student_name);
        department = findViewById(R.id.student_department);
        present_address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);

        addStudent = findViewById(R.id.button_addStudent);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sid = id.getText().toString();
                mStudent.setValue(sid);

                String sname = name.getText().toString();
                mStudent.setValue(sname);

                String dept = department.getText().toString();
                mStudent.setValue(dept);

                String padd = present_address.getText().toString();
                mStudent.setValue(padd);

                String phn = phone.getText().toString();
                mStudent.setValue(phn);
            }
        });
    }





}