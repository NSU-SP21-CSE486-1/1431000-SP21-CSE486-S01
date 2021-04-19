package com.shawonarefin.android.roomdbv05.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shawonarefin.android.roomdbv05.R;
import com.shawonarefin.android.roomdbv05.datasource.local.room.entity.StudentInfo;
import com.shawonarefin.android.roomdbv05.uicontroller.AddStudentPersonalinfoActivity;
import com.shawonarefin.android.roomdbv05.viewmodel.StudentInfoViewModel;



public class AddStudentContactActivity extends AddStudentPersonalinfoActivity implements AppCompatActivity{

    EditText country = findViewById(R.id.presentcountry);
    EditText district = findViewById(R.id.presentdistrict);
    EditText pOffice = findViewById(R.id.presentpo);
    EditText pStation = findViewById(R.id.presentps);
    EditText pCode = findViewById(R.id.presentpc);
    EditText houseNo = findViewById(R.id.presenthouseno);
    EditText roadNo = findViewById(R.id.presentroadno);







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AddStudentContactActivity.this, StudentIDRecyclerAdapter.class);

            }
        });
    }
}
