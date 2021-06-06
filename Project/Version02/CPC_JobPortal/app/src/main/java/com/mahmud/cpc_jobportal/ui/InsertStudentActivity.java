package com.mahmud.cpc_jobportal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmud.cpc_jobportal.Model.StudentData;
import com.mahmud.cpc_jobportal.R;

import org.w3c.dom.Text;

import java.lang.reflect.Member;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertStudentActivity extends AppCompatActivity {

    private EditText sid, sname, sdepartment, spresent_address, sphone;
    TextView date_tv;
    DatePickerDialog.OnDateSetListener listener;

//    String [] departments = {"Choose Department", "Dept. of Engineering", "Dept. of Business", "Dept. of Social Science", "Dept. of Law"};

    private Button addStudent;

    FirebaseAuth mAuth;
    //FirebaseDatabase studentRoot;
    DatabaseReference studentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        //Firebase start
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uID = mUser.getUid(); //get uID from the firestore database
        studentReference = FirebaseDatabase.getInstance().getReference().child("Students").child(uID);

        InsertStudent();
    }


    private void InsertStudent() {

        sid = findViewById(R.id.student_id);
        sname = findViewById(R.id.student_name);
        sdepartment = findViewById(R.id.department);
        spresent_address = findViewById(R.id.address);
        sphone = findViewById(R.id.phone);

        //Implementing date
        date_tv = findViewById(R.id.date_tv);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);
        date_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertStudentActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, listener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();}  });
        listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                date_tv.setText(date);
            }
        };

            addStudent = findViewById(R.id.button_addStudent);
            addStudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   String id = sid.getText().toString().trim();
                   String name = sname.getText().toString().trim();
                   String department = sdepartment.getText().toString();
                   String present_address = spresent_address.getText().toString().trim();
                   String phone = sphone.getText().toString().trim();
                   String dob = listener.toString().trim();

                   if(TextUtils.isEmpty(id)){
                       sid.setError("Enter Student ID!");
                       return;
                   }
                   if (TextUtils.isEmpty(name)){
                       sname.setError("Enter name!");
                       return;
                   }
                   if (TextUtils.isEmpty(department)){
                       sdepartment.setError("Choose department!");
                       return;
                   }
                   if(TextUtils.isEmpty(present_address)){
                       spresent_address.setError("Enter Address");
                       return;
                   }
                   if (TextUtils.isEmpty(phone)){
                       sphone.setError("Enter a phone number!");
                       return;
                   }
                   if (TextUtils.isEmpty(dob)){
                       Toast.makeText(InsertStudentActivity.this, "Please select a date", Toast.LENGTH_SHORT).show();
                   }

                   String uniqueID = studentReference.push().getKey();
                   String DateEntered = DateFormat.getDateInstance().format(new Date());

                   StudentData studentData = new StudentData(id, name, department, present_address, phone, dob);
                   studentReference.child(id).setValue(studentData);

                    Toast.makeText(getApplicationContext(), "Student Data entered Successfully!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), StudentDashboardActivity.class));
                }
            });



        }

    }



