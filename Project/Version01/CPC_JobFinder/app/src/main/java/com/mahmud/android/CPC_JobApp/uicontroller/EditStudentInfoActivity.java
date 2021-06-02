package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.StudentInfo;

public class EditStudentInfoActivity extends AppCompatActivity {

  private static Integer DEFAULT_STUDENT_ID = 0;

  TextView studentID_TextView;
  EditText name_EditText;
  EditText age_EditText;

  Button updateButton;
  Button cancelButton;

  private StudentInfoViewModel mWordViewModel;
  private StudentInfo mStudentInfo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_student_info);

    mWordViewModel = (new ViewModelProvider(this
        ,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))).get(StudentInfoViewModel.class);

    //TODO get data from DisplayStudentIDsActivity
    Integer studentID = getIntent().getIntExtra(DisplayStudentIDsActivity.STUDENT_ID
        ,DEFAULT_STUDENT_ID);


    studentID_TextView = findViewById(R.id.page3_studentID_display_textView);
    name_EditText = findViewById(R.id.page3_name_editText);
    age_EditText = findViewById(R.id.page3_studentAge_editText);
    updateButton = findViewById(R.id.page3_updateButton);
    cancelButton = findViewById(R.id.page3_cancelButton);

    mWordViewModel.getStudent(studentID).observe(this, new Observer<StudentInfo>() {
      @Override
      public void onChanged(StudentInfo studentInfo) {
        studentID_TextView.setText(studentInfo.getStudentID().toString());
        name_EditText.setText(studentInfo.getStudentName());
        age_EditText.setText(studentInfo.getStudentAge().toString());

        mStudentInfo = studentInfo;
      }
    });

    updateButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String name = name_EditText.getText().toString();
        Integer age = Integer.parseInt(age_EditText.getText().toString());

        boolean isDataChanged = false;

        //TODO Update this data in Room Database
        if(!mStudentInfo.getStudentName().equals(name)){
          mStudentInfo.setStudentName(name);
          isDataChanged = true;
        }

        if(!mStudentInfo.getStudentAge().equals(age)){
          mStudentInfo.setStudentAge(age);
          isDataChanged = true;
        }

        if(isDataChanged) {
          Toast.makeText(view.getContext()
              , "Data Updated"
              , Toast.LENGTH_LONG).show();

          mWordViewModel.update(mStudentInfo);
          finish();
        }else{
          Toast.makeText(view.getContext()
              , "No Data Updated"
              , Toast.LENGTH_LONG).show();
        }
      }
    });

    cancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(view.getContext()
            , "Returning to Student ID List"
            , Toast.LENGTH_LONG).show();
        finish();
      }
    });
  }
}