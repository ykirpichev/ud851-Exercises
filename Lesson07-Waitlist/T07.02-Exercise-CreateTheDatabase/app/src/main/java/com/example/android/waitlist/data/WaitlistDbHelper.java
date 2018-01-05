package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WaitlistDbHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "waitlist.db";

    private static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WAITLIST_TABLE =
                "create table " + WaitlistContract.WaitlistEntry.TABLE_NAME + " (" +
                        WaitlistContract.WaitlistEntry._ID + " integer primary key autoincrement," +
                        WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " text not null," +
                        WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " integer not null," +
                        WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " timestamp default current_timestamp" +
                        ");";

        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }
}