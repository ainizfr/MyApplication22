package com.example.zfr.myapplication2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
    final String CREATE_TABLE_SQL = "create table addbook( num integer PRIMARY KEY  NOT NULL ,name VARCHER(20) not null)";

    public MyDatabaseHelper(Context context, String name ,int version){
        super(context,name,null,version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //第一次使用数据库时创建表
        db.execSQL(CREATE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
