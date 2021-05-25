package com.mahmud.android.CPC_JobApp.datasource.local.room.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "cpcdatabase.db";
    final static int DBVERSION = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table jobs" +
                        "(id integer primary key autoincrement," +
                        "price text," +
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

    public boolean apply
}
