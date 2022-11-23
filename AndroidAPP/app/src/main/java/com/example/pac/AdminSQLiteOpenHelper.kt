package com.example.pac

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION

class AdminSQLiteOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?
                            , version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table personajes(nombre string primary key, tipo string, karma string)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}