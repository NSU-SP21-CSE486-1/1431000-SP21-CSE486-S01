package com.shawonarefin.android.roomdbv05.uicontroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shawonarefin.android.roomdbv05.R;
import com.shawonarefin.android.roomdbv05.datasource.local.room.entity.StudentInfo;
import com.shawonarefin.android.roomdbv05.viewmodel.StudentInfoViewModel;

import java.util.List;

public class DisplayStudentIDsActivity
    extends AppCompatActivity
    implements StudentIDRecyclerAdapter.OnStudentIDListener{

  public static String STUDENT_DATA = "STUDENT_DATA";
  public static String STUDENT_ID = "STUDENT_ID";

  private RecyclerView mRecyclerView;
  private StudentIDRecyclerAdapter mAdapter;
  private FloatingActionButton mFabButton;

  private StudentInfoViewModel mWordViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_student_ids);

    mWordViewModel = (new ViewModelProvider(this
        ,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))).get(StudentInfoViewModel.class);

    mRecyclerView = findViewById(R.id.recyclerview);
    mAdapter = new StudentIDRecyclerAdapter(this
        , mWordViewModel.getAllStudents().getValue());

    mWordViewModel.getAllStudents().observe(this, new Observer<List<StudentInfo>>() {
      @Override
      public void onChanged(List<StudentInfo> students) {
        mAdapter.setStudentIDList(students);
        mAdapter.notifyDataSetChanged();
      }
    });

    Button searchButton = findViewById(R.id.button_search);
    searchButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent searchIntent = new Intent(DisplayStudentIDsActivity.this, SearchActivity.class);

      }
    });


    mRecyclerView.setAdapter(mAdapter);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mFabButton = findViewById(R.id.list_add_fab_button);
    mFabButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), AddStudentActivity.class);
        startActivity(intent);
      }
    });

    ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
      @Override
      public boolean onMove(@NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            @NonNull RecyclerView.ViewHolder target) {
        return false;
      }

      @Override
      public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder
          , int direction) {
        int position = viewHolder.getAdapterPosition();
        StudentInfo infoToDelete = mAdapter.getStudentInfoAtPosition(position);
        mWordViewModel.delete(infoToDelete);
      }
    });
    helper.attachToRecyclerView(mRecyclerView);
  }

  @Override
  public void onStudentIDClick(int position) {
    Integer idVal  = mAdapter.getStudentID(position);
    if(idVal == null){
      Toast.makeText(this, "Error",Toast.LENGTH_LONG).show();
    }else{
      Intent intent = new Intent(this, EditStudentInfoActivity.class);
      StudentInfo studentInfo = mWordViewModel.getStudent(idVal).getValue();
      intent.putExtra(STUDENT_ID, idVal);
      startActivity(intent);
    }

  }



}