package com.example.myapplication.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private final static String DBNAME="vipuser.db";
    private final static int VERSION=1;
    private final static String CREATEDB="create table user(id integer primary key " +
            "autoincrement,name varchar(10),pwd varchar(10),gender varch(10)," +
            "hobby varchar(50),origin varchar(60))";
    public MyDBHelper(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATEDB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table user");
        onCreate(db);

    }
}
