package com.example.asianery5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "Asianery.db";

    private static final String CREATE_STUDENT_TABLE = "CREATE TABLE " + DatabaseInfo.TABLE_NAME + "(" + DatabaseInfo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            DatabaseInfo.CountryName + " text," +
            DatabaseInfo.CountryDescription + " text," +
            DatabaseInfo.CountryExperience  + " text," +
            DatabaseInfo.PersonName  + " text)";
    private static final String DELETE_ASIANERY_TABLE = "DROP TABLE IF EXISTS " + DatabaseInfo.TABLE_NAME;

    public OpenHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_ASIANERY_TABLE);
        onCreate(sqLiteDatabase);
    }
}
