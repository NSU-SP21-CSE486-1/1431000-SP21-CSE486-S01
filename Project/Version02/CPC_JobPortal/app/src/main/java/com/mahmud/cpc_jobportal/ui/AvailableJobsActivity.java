package com.mahmud.cpc_jobportal.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmud.cpc_jobportal.R;

import org.w3c.dom.Text;

public class AvailableJobsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    //Firebase Database

    FirebaseAuth mAuth;
    DatabaseReference JobPostDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser(); //CHECK THIS LINE FOR REFERENCE

        String uID = mUser.getUid();

        JobPostDB = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uID);


        recyclerView = findViewById(R.id.recycler_job_post_id);
        //LayoutManaging
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);




    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View myView;

        public MyViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
        }
        public void setJobTitle(String position){
            TextView mPosition = myView.findViewById(R.id.job_name);
            mPosition.setText(position);
        }

        public void setJobDate(String date){
            TextView mDate = myView.findViewById(R.id.job_post_date);
            mDate.setText(date);
        }

        public void setJobDescription(String description){
            TextView mDescription = myView.findViewById(R.id.job_description);
            mDescription.setText(description);
        }

        public void setJobSalary(String salary){
            TextView mSalary = myView.findViewById(R.id.job_salary);
            mSalary.setText(salary);
        }
    }
}