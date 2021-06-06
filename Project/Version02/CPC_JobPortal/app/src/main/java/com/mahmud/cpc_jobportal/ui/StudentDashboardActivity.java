package com.mahmud.cpc_jobportal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmud.cpc_jobportal.R;

public class StudentDashboardActivity extends AppCompatActivity {

    private Button btn_addRecord, btn_viewJobs, btn_logoutStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        btn_addRecord = findViewById(R.id.button_addRecord);
        btn_viewJobs = findViewById(R.id.button_viewJobs);

        btn_addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InsertStudentActivity.class));
            }
        });

        btn_viewJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AvailableJobsActivity.class));

            }
        });

        //Logging out
        btn_logoutStudent = findViewById(R.id.button_logout_student);
        btn_logoutStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentLoginActivity.class));
            }
        });

    }
}