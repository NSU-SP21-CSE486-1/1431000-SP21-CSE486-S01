package com.mahmud.cpc_jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmud.cpc_jobportal.Model.JobData;

import java.text.DateFormat;
import java.util.Date;

public class InsertJobActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText position_name, company_name, job_description, job_salary;

    private Button post_button;
    private FirebaseAuth mAuth; //Firebase Auth
    private DatabaseReference mJobPost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job);

        toolbar = findViewById(R.id.insert_job_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Post Job");

        //Firebase Authentication
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uID = mUser.getUid(); //get uID from the firestore database
        mJobPost = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uID);
        //Job Post database

        InsertJob();

    }

    private void InsertJob(){

        position_name = findViewById(R.id.position_name);
        company_name = findViewById(R.id.company_name);
        job_description = findViewById(R.id.job_description);
        job_salary = findViewById(R.id.salary);

        post_button = findViewById(R.id.button_postjob);
        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String position = position_name.getText().toString().trim();
                String company = company_name.getText().toString().trim();
                String description = job_description.getText().toString().trim();
                String salary = job_salary.getText().toString().trim();

                if(TextUtils.isEmpty(position)){
                    position_name.setError("Enter Job position");
                    return;
                }
                if(TextUtils.isEmpty(company)){
                    company_name.setError("Enter Company Name");
                    return;
                }
                if(TextUtils.isEmpty(description)){
                    job_description.setError("Enter Job description");
                    return;
                }
                if(TextUtils.isEmpty(salary)){
                    job_salary.setError("Enter Salary.");
                    return;
                }

                String id = mJobPost.push().getKey(); //Random Key generate for specific uID
                String date = DateFormat.getDateInstance().format(new Date());

                JobData jobData = new JobData(position, company, description, salary, id, date);
                mJobPost.child(id).setValue(jobData);

                //Adding data to firebase database

                Toast.makeText(getApplicationContext(), "Data entered!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), InsertJobActivity.class));



            }
        });
    }

}