package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.entity.Column;
import com.example.myapplication.entity.User;

import java.sql.SQLData;

public class UserDao {
    Context context;
    SQLiteDatabase db;
    MyDBHelper dbHelper;

    public UserDao(Context context) {
        this.context = context;
        dbHelper=new MyDBHelper(context);
        db=dbHelper.getReadableDatabase();
    }
    public void addUser(User user){
        ContentValues values=new ContentValues();
        int i=0;
        String[] users=user.toString().split("\\|");
        for (Column col:Column.values()){
            if (i!=0)
            values.put(col.getColumnName(),users[i]);
            i++;

        }
        db.insert("user",null,values);
    }
}
