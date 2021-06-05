package com.mahmud.cpc_jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDashboardActivity extends AppCompatActivity {

    private Button btn_addrecord, btn_viewjobs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_dashboard);

        btn_addrecord = findViewById(R.id.button_addRecord);
        btn_viewjobs = findViewById(R.id.button_viewjobs);

        btn_addrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InsertStudentActivity.class));
            }
        });

        btn_viewjobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AvailableJobsActivity.class));

            }
        });

    }
}