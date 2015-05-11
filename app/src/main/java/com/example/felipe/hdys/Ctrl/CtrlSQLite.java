package com.example.felipe.hdys.Ctrl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Felipe on 04/05/2015.
 */
public class CtrlSQLite extends SQLiteOpenHelper {


    public CtrlSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table palabras (" +
                "id integer primary key, " +
                "espanol text, " +
                "buena text, " +
                "mala text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists palabras");
        db.execSQL("create table palabras (" +
                "id integer primary key, " +
                "espanol text, " +
                "buena text, " +
                "mala text)");
    }
}
