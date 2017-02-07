package com.example.danil.android;

import android.content.ContentValues;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.util.Log;
import com.example.danil.android.databaseHelper.AndroidDataHelper;
import org.junit.Test;

/**
 * Created by _dani on 07.02.2017.
 */
public class databaseHelperTest {
    private static final String TAG = databaseHelperTest.class.getSimpleName();

    @Test
    public void createDatabase() {
        Context context = InstrumentationRegistry.getTargetContext();
        AndroidDataHelper helper = new AndroidDataHelper(context);
        final SQLiteDatabase writableDatabase = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("title", "super song " + System.currentTimeMillis());

        writableDatabase.insert("audio", null, cv);

        final Cursor cursor = writableDatabase.query("audio", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            final int columnTitleIndex = cursor.getColumnIndex("title");
            do {
                final String title = cursor.getString(columnTitleIndex);
                Log.d(TAG, " title of current song " + title);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
