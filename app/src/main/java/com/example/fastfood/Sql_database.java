package com.example.fastfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sql_database extends SQLiteOpenHelper {

    public static final String databaseName = "signup_db2";

    public Sql_database(@Nullable Context context ) {
        super(context, "signup_db2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydatabase) {
        Mydatabase.execSQL("create Table allusers( email  primary key, password )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydatabase, int i, int i1) {
        Mydatabase.execSQL("drop Table if exists allusers");
    }

    public boolean insertData(String email, String password){
        SQLiteDatabase Mydatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);

        long result = Mydatabase.insert("allusers", null,contentValues);

        if (result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public boolean check_email(String email){
        SQLiteDatabase Mydatabase =this.getWritableDatabase();
        Cursor cursor = Mydatabase.rawQuery("Select *  from allusers where email = ?",new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        }else {
            return  false;
        }
    }


    public boolean check_email_password(String email, String password){
        SQLiteDatabase Mydatabase =this.getWritableDatabase();
        Cursor cursor = Mydatabase.rawQuery("Select * from allusers where email = ? and password = ?",new String[]{email,password} );

        if (cursor.getCount() > 0){
            return true;
        }else {
            return  false;
        }
    }
}

