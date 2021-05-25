package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.StudentInfoViewModel;



public class AddStudentContactActivity extends AddStudentPersonalinfoActivity implements AppCompatActivity{



    EditText country = findViewById(R.id.presentcountry);
    EditText district = findViewById(R.id.presentdistrict);
    EditText pOffice = findViewById(R.id.presentpo);
    EditText pStation = findViewById(R.id.presentps);
    EditText pCode = findViewById(R.id.presentpc);
    EditText houseNo = findViewById(R.id.presenthouseno);
    EditText roadNo = findViewById(R.id.presentroadno);

    Button savebutton = findViewById(R.id.save_button);


    private StudentInfoViewModel mWordViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students_contact);

        mWordViewModel = (new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))).get(Student)
    }
}
