package com.shawonarefin.android.roomdbv05.repository;

import android.app.Application;

import com.shawonarefin.android.roomdbv05.datasource.local.room.dao.StudentInfoDao;
import com.shawonarefin.android.roomdbv05.datasource.local.room.database.AppDatabase;
import com.shawonarefin.android.roomdbv05.datasource.local.room.entity.StudentInfo;

import java.util.List;

import androidx.lifecycle.LiveData;

public class StudentRepository {
  private StudentInfoDao mStudentInfoDao;
  private LiveData<List<Integer>> mAllStudentIds;
  private LiveData<List<StudentInfo>> mAllStudents;


  public StudentRepository(Application application){
    AppDatabase db = AppDatabase.getDatabase(application);
    mStudentInfoDao = db.studentInfoDao();
    mAllStudentIds = mStudentInfoDao.getAllIds();
    mAllStudents = mStudentInfoDao.getAllStudents();
  }

  public LiveData<List<Integer>> getAllStudentIDs(){
    return mAllStudentIds;
  }

  public LiveData<List<StudentInfo>> getAllStudents(){
    return mAllStudents;
  }

  // Room executes all queries on a separate thread.
  // Observed LiveData will notify the observer when the data has changed.
  public LiveData<StudentInfo> getStudent(Integer id){
    return mStudentInfoDao.getStudent(id);
  }

  public void insert(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.insert(studentInfo);
    });
  }

  public void insertAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.insertAll(studentInfos);
    });
  }

  public void delete(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.delete(studentInfo);
    });
  }

  public void deleteAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.deleteAll(studentInfos);
    });
  }

  public void update(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.update(studentInfo);
    });
  }

  public void updateAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.updateAll(studentInfos);
    });
  }
}
