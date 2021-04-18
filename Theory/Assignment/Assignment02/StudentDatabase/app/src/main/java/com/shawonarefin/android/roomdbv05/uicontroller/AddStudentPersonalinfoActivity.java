package com.shawonarefin.android.roomdbv05.uicontroller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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

public class AddStudentPersonalinfoActivity extends AddStudentActivity {

    Spinner schoolSpinner, deptSpinner;
    //DatePicker dob = findViewById(R.id.editTextDate);
    EditText nid = findViewById(R.id.nid_text);




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        schoolSpinner = findViewById(R.id.school_spinner);
        deptSpinner = findViewById(R.id.department_spinner);

        populateSpinnerSchool();
        populateSpinnerDepartment();
        
    }

    private void populateSpinnerSchool() {
        ArrayAdapter <String> schoolAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.school_spinner));

        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpinner.setAdapter(schoolAdapter);
    }
    private void populateSpinnerDepartment() {

    }

}
