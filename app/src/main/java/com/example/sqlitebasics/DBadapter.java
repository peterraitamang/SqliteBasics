package com.example.sqlitebasics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBadapter {
    myDbHelper myHelper;
    public DBadapter(Context context)
    {
        myHelper = new myDbHelper(context);
    }

    public long insertData(String name, String pass)
    {
        SQLiteDatabase dbb = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MyPASSWORD, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME,null, contentValues);
        return id;
    }
    public String getData()
    {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MyPASSWORD};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
       return buffer.toString();
    }



    static class myDbHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "myDatabase";
        private static final String TABLE_NAME = "myTable";
        private static final int DATABASE_Version = 1;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String MyPASSWORD = "Password";
        private static final String CREATE_TABLE ="CREATE TABLE" + TABLE_NAME +
                "("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+"VARCHAR(255),"+MyPASSWORD+"VARCHAR(255));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS" +TABLE_NAME;
        private Context context;
        public myDbHelper(Context context){
            super(context, DATABASE_NAME, null,DATABASE_Version);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion , int newVersion) {

        }
    }
}
