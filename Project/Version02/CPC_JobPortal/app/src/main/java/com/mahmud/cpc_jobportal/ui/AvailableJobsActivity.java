package com.mahmud.cpc_jobportal.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmud.cpc_jobportal.Model.JobData;
import com.mahmud.cpc_jobportal.Model.StudentData;
import com.mahmud.cpc_jobportal.R;
import com.mahmud.cpc_jobportal.adapter.JobAdapter;

import org.w3c.dom.Text;

public class AvailableJobsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    JobAdapter adapter;
    DatabaseReference jobReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);

        jobReference = FirebaseDatabase.getInstance().getReference().child("Job Post");
        jobReference.keepSynced(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_job_post_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



//        recyclerView = (RecyclerView) findViewById(R.id.recycler_job_post_id);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        FirebaseRecyclerOptions<JobData> options =
//                new FirebaseRecyclerOptions.Builder<JobData>()
//                .setQuery(FirebaseDatabase.getInstance().getReference().child("Job Post"), JobData.class).build();
//
//
//        adapter = new JobAdapter(options);
//        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        adapter.stopListening();
//    }
}