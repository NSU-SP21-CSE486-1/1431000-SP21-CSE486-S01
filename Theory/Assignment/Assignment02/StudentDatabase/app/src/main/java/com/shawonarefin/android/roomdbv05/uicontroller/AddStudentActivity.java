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
import com.shawonarefin.android.roomdbv05.viewmodel.StudentInfoViewModel;

public class AddStudentActivity extends AppCompatActivity {

  EditText studentIDEditText;
  EditText studentNameEditText;
  EditText studentAgeEditText;
  Button saveButton;
  Button clearButton;

  Button nextButton;

  private StudentInfoViewModel mWordViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_student);

    mWordViewModel = (new ViewModelProvider(this
        ,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))).get(StudentInfoViewModel.class);

    studentIDEditText = findViewById(R.id.editTextStudentID);
    studentNameEditText = findViewById(R.id.editTextPersonName);
    studentAgeEditText = findViewById(R.id.editTextPersonAge);

    saveButton = findViewById(R.id.save_button);

    nextButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String idString = studentIDEditText.getText().toString();
        Integer id = Integer.valueOf(idString);

        String name = studentNameEditText.getText().toString();
        String ageString = studentAgeEditText.getText().toString();
        Integer age = Integer.valueOf(ageString);

        if(studentIDEditText.getText().toString().isEmpty() || (studentIDEditText >1111111 && studentIDEditText<9999999)){
          Toast.makeText(AddStudentActivity.this, "Invalid Student ID. Enter Again. (Format: 7 digit)", Toast.LENGTH_LONG).show();
          studentIDEditText.setText("");
        }
        else{
          StudentInfo info = new StudentInfo(id, name, age);
          mWordViewModel.insert(info);
          Toast.makeText(AddStudentActivity.this, "Data Added! Next Page", Toast.LENGTH_SHORT).show();

          Intent intent = new Intent(AddStudentActivity.this, AddStudentPersonalinfoActivity.class);

        }

      }
    });

//    saveButton.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        String idString = studentIDEditText.getText().toString();
//        Integer id = Integer.valueOf(idString);
//
//        String name = studentNameEditText.getText().toString();
//        String ageString = studentAgeEditText.getText().toString();
//        Integer age = Integer.valueOf(ageString);
//
//        StudentInfo info = new StudentInfo(id, name, age);
//        mWordViewModel.insert(info);
//
//        studentAgeEditText.setText("");
//        studentIDEditText.setText("");
//        studentNameEditText.setText("");
//
//        Toast.makeText(view.getContext(),
//            "Student ID : " + idString + " saved.",
//            Toast.LENGTH_LONG).show();
//
//        finish();
//      }
//    });



    clearButton = findViewById(R.id.clear_button);
    clearButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        studentAgeEditText.setText("");
        studentIDEditText.setText("");
        studentNameEditText.setText("");

        Toast.makeText(view.getContext(),
            "Data cleared.",
            Toast.LENGTH_LONG).show();
      }
    });
  }



}