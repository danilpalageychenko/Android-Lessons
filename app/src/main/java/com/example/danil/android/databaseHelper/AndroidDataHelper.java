package com.example.danil.android.databaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;

/**
 * Created by _dani on 07.02.2017.
 */
public class AndroidDataHelper extends SQLiteOpenHelper {
    private static final String TAG = AndroidDataHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "android1.db";
    private static final int DATABASE_VERSION = 3;

    public AndroidDataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate: ");
        sqLiteDatabase.execSQL("create table audio(_id integer primary key, title text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
        onCreate(sqLiteDatabase);
    }
}
