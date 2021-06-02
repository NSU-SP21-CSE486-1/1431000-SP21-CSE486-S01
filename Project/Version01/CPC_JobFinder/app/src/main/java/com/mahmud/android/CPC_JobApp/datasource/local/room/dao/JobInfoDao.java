package com.mahmud.android.CPC_JobApp.datasource.local.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mahmud.android.CPC_JobApp.entity.JobInfoModel;
import com.mahmud.android.CPC_JobApp.entity.StudentInfo;

import java.util.List;

/**
 * Perform CRUD operations on student_info table defined by StudentInfo entity
 * C = @Insert
 * R = @Query
 * U = @Update
 * D = @Delete
 */
@Dao
public interface JobInfoDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(JobInfoModel JobInfoModel);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertAll(JobInfoModel... jobInfoModels);

  @Query("SELECT id FROM job_info ORDER BY id ASC")
  LiveData<List<Integer>> getAllIds();

  @Query("SELECT * FROM student_info ORDER BY id ASC")
  LiveData<List<StudentInfo>> getAllStudents();

  @Query("SELECT * FROM student_info WHERE id LIKE :studentID LIMIT 1")
  LiveData<StudentInfo> getStudent(Integer studentID);


//Department Query
  @Query("SELECT department FROM student_info WHERE id = id")
  LiveData<StudentInfo> getStudentdept(String department);



  @Update
  void update(StudentInfo studentInfo);

  @Update
  void updateAll(StudentInfo... studentInfo);

  @Delete
  void delete(StudentInfo studentInfo);

  @Delete
  void deleteAll(StudentInfo... studentInfos);
}
