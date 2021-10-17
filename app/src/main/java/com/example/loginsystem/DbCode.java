package com.example.loginsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbCode extends SQLiteOpenHelper {
    public DbCode(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key,password TEXT,Email TEXT,Gender Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists users");
    }
    public boolean insertData(String user,String pass,String email,String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",pass);
        contentValues.put("Email",email);
        contentValues.put("Gender",gender);
        long result = db.insert("users",null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return  true;
        }
    }
    public boolean checkUser(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?",new String[]{user});
        if (cursor.getCount()>0){
            return false;
        }
        else{
            return  true;
        }
    }
    public  boolean CheckUserPass(String user,String pass){
     SQLiteDatabase db = this.getWritableDatabase();
     Cursor cursor = db.rawQuery("select * from users where username=? and password = ?",new String[]{user,pass});
     if (cursor.getCount()>0){
         return  true;
     }
     else{
         return false;
     }
    }
}
