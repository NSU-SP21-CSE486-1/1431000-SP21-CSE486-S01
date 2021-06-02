package com.mahmud.android.CPC_JobApp.datasource.local.room.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.mahmud.android.CPC_JobApp.entity.StudentApplyModel;
import com.mahmud.android.CPC_JobApp.entity.MainModel;
import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "cpcdatabase.db";
    final static int DBVERSION = 2;


    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table jobs" +
                        "(id integer primary key autoincrement," +
                        "salary text," +
                        "image int, " +
                        "description text," +
                        "positionname text)"
        );

        sqLiteDatabase.execSQL(
                "create table company " +
                        "(bio text, " +
                        "companyID text  primary key)"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {
        sqLiteDatabase.execSQL("DROP table if exists jobs");
        sqLiteDatabase.execSQL("DROP table if exists company");
        onCreate(sqLiteDatabase);
    }


    public boolean insertJob(String jobsalary, int jobimage, String jobdescription, String jobname) {
        
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Salary", jobsalary);
        values.put("image", jobimage);
        values.put("jobdescription", jobdescription);
        values.put("jobname", jobname);
        long id = database.insert("jobs", null, values);
        
        if (id<=0){return false;}
        else{return true;}
        
    }
    
    //This will view the job placement from the student from the database CPCdatabase
    
    public ArrayList<StudentApplyModel> getOrders(){
        ArrayList<StudentApplyModel> jobs = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("Select id, foodname, image, price from orders ",null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()){
                StudentApplyModel studentApplyModel = new StudentApplyModel();
                StudentApplyModel.setApplyNumber(cursor.getInt(0 )+ "");
                StudentApplyModel.setAppliedJob(cursor.getString(1));
                StudentApplyModel.setApplyImage(cursor.getInt(2));
                StudentApplyModel.setSalary(cursor.getString(3));
                jobs.add(StudentApplyModel);


            }
        }
        //to prevent it from memory leakage
        cursor.close();
        sqLiteDatabase.close();
        return jobs;

    }

    public int deleteJob(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("jobs", "id="+id, null);
    }

    public boolean insertCompany(String companyName, String bio){

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("companyName", companyName);
        values.put("bio", bio);
        long id = database.insert("company", null, values);
        if(id<=0){
            return false;
        }

    }

    public ArrayList<MainModel> getCompany(){
        ArrayList<MainModel> company = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        Cursor cursor = sqLiteDatabase.rawQuery("Select  OutletName, bio from orders ",null);
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()){
                MainModel mainModel = new MainModel();
                mainModel.setName(cursor.getInt(0 )+ "");
                mainModel.setDescription(cursor.getString(1));
                company.add(MainModel);


            }
        }
        //Preventing memory leakage
        cursor.close();
        sqLiteDatabase.close();
        return company;

    }





    
    
}
