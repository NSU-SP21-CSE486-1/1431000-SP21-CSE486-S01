package com.shawonarefin.android.roomdbv05.datasource.local.room.dao;

import com.shawonarefin.android.roomdbv05.datasource.local.room.entity.StudentInfo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Perform CRUD operations on student_info table defined by StudentInfo entity
 * C = @Insert
 * R = @Query
 * U = @Update
 * D = @Delete
 */
@Dao
public interface StudentInfoDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(StudentInfo studentInfo);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertAll(StudentInfo... studentInfos);

  @Query("SELECT id FROM student_info ORDER BY id ASC")
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
