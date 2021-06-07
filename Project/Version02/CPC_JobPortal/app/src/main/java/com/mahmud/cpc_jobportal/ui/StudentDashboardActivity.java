package com.mahmud.cpc_jobportal.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mahmud.cpc_jobportal.Model.StudentData;
import com.mahmud.cpc_jobportal.R;

import org.w3c.dom.Text;

public class StudentDashboardActivity extends AppCompatActivity {

    private Button btn_addRecord, btn_viewJobs, btn_logoutStudent;
//    //
//    private FirebaseUser user;
//    private DatabaseReference reference;
//    private String userID;


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
                Toast.makeText(StudentDashboardActivity.this, "Logging Out. Thanks!", Toast.LENGTH_SHORT).show();
            }
        });

//        user = FirebaseAuth.getInstance().getCurrentUser();
//        reference = FirebaseDatabase.getInstance().getReference();
//        userID = user.getUid();
//
//        final TextView welcomeTextView = (TextView) findViewById(R.id.emailaddresstitle);
//
//        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                StudentData studentData = snapshot.getValue(StudentData.class);
//
//                if (studentData != null){
//                    String name = studentData.getName();
//                    String id = studentData.getId();
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });



    }
}