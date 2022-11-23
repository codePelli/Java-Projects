package com.example.pac

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLManager(context: Context):SQLiteOpenHelper(context, "personajes.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
            db!!.execSQL("CREATE TABLE personajes(nombre VARCHAR(20) PRIMARY KEY, tipo VARCHAR(20), karma VARCHAR(10)  )")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")

    }

    fun addPersonajes(context: Context, datos:Characters):Boolean{
        var respuesta = true
        var cValues = ContentValues()
            cValues.put("nombre","datos.nombre")
            cValues.put("tipo","datos.tipo")
            cValues.put("karma", "datos.karma")
                var db = SQLManager(context)
                var manager = db.writableDatabase

                try {
                    manager.insert("personajes.db", null,cValues)
                }catch (e: Exception){
                    print(e.message)
                    respuesta = false
                }
                finally {
                    db.close()
                }

                return respuesta
    }
}