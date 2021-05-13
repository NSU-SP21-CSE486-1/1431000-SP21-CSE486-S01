package com.shawonarefin.android.roomdbv05.uicontroller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.shawonarefin.android.roomdbv05.R;
import com.shawonarefin.android.roomdbv05.datasource.local.room.entity.StudentInfo;
import com.shawonarefin.android.roomdbv05.viewmodel.StudentInfoViewModel;

import java.util.Date;

public class AddStudentPersonalinfoActivity extends AddStudentActivity implements AppCompatActivity {


    Spinner schoolSpinner, departmentSpinner;
    //DatePicker dob = findViewById(R.id.editTextDate);
    EditText nid = findViewById(R.id.nid_text);

    schoolSpinner = findViewById(R.id.school_spinner);
    departmentSpinner = findViewById(R.id.department_spinner)

    Button nextButton;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


// School and Department choosing through Spinner method
        private void populateSpinnerSchool() {
            ArrayAdapter <String> schoolAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.school_spinner));

            schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            schoolSpinner.setAdapter(schoolAdapter);
        }
        private void populateSpinnerDepartment() {

            ArrayAdapter <String> departmentAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.department_spinner));

            departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            departmentSpinner.setAdapter(departmentAdapter);

        }


        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sspinner = schoolSpinner.getSelectedItem().toString();

                String dspinner = departmentSpinner.getSelectedItem().toString();


                Intent intent = new Intent(AddStudentPersonalinfoActivity.this, AddStudentContactActivity.class);
                startActivity(intent);
            }
        });

    }



}
