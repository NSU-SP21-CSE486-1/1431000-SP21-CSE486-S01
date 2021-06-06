package com.mahmud.cpc_jobportal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmud.cpc_jobportal.R;

public class JobDashboardActivity extends AppCompatActivity {

    private Button btn_alljob, btn_postjob, btn_logoutCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_dashboard);

        btn_alljob = findViewById(R.id.button_alljobs);
        btn_postjob = findViewById(R.id.button_postjob);

        btn_alljob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AvailableJobsActivity.class));
            }
        });

        btn_postjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InsertJobActivity.class));

            }
        });

        //Logging out
        btn_logoutCompany = findViewById(R.id.button_logout_company);
        btn_logoutCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CompanyLoginActivity.class));
            }
        });

    }
}