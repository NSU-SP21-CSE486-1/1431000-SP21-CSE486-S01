package com.mahmud.android.CPC_JobApp.datasource.local.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mahmud.android.CPC_JobApp.datasource.local.room.dao.StudentInfoDao;
import com.mahmud.android.CPC_JobApp.entity.StudentInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {StudentInfo.class}, version = 3)

public abstract class AppDatabase extends RoomDatabase {
  public abstract StudentInfoDao studentInfoDao(); //Abstract method implemented by Room

  private static AppDatabase INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;
  private static final ExecutorService databaseWriteExecutor =
      Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public static ExecutorService getDatabaseWriteExecutor(){
    return databaseWriteExecutor;
  }

  public static AppDatabase getDatabase(final Context context){
    if(INSTANCE == null){
      synchronized (AppDatabase.class){
        if(INSTANCE == null){
          INSTANCE = Room.databaseBuilder(context.getApplicationContext()
              ,AppDatabase.class, "student_db")
                  .allowMainThreadQueries().build();

        }
      }
    }
    return INSTANCE;
  }
}
