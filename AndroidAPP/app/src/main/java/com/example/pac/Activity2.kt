package com.example.pac

import android.content.ContentValues
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast



class Activity2 : AppCompatActivity() {

    lateinit var btnActivity1: Button
    lateinit var btnCrear: Button
    lateinit var btnInsertar: Button
    lateinit var btnConsultar: Button

    lateinit var charName: EditText
    lateinit var charType: EditText
    lateinit var charKarma : EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        var bundle = intent.extras
        var toast = bundle!!.getString("hola")
        Toast.makeText(this, toast,Toast.LENGTH_SHORT).show()

        btnConsultar = findViewById(R.id.buttonConsultar)
        btnInsertar = findViewById(R.id.buttonInsertar)
        btnActivity1 = findViewById(R.id.buttonActivity1)
        btnActivity1.setOnClickListener{
            val goToActivity1 = Intent(this, MainActivity::class.java)
            startActivity(goToActivity1)
        }

        btnCrear = findViewById(R.id.buttonCrear)
        charName = findViewById(R.id.editTextNombre)
        charType = findViewById(R.id.editTextType)
        charKarma = findViewById(R.id.buttonKarma)

        btnCrear.setOnClickListener{

            val admin = AdminSQLiteOpenHelper(this, "personajes", null, 1)
            val db = admin.writableDatabase
            Toast.makeText(this,"Se creó la tabla 'personajes' ", Toast.LENGTH_SHORT).show()

        }

        btnInsertar.setOnClickListener{

            val admin = AdminSQLiteOpenHelper(this, "personajes", null, 1)
            val db = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", charName.getText().toString())
            registro.put("tipo", charType.getText().toString())
            registro.put("karma", charKarma.getText().toString())
            db.insert("personajes", null,registro)
            db.close()
            charName.setText("")
            charType.setText("")
            charKarma.setText("")
            Toast.makeText(this,"Se introdujeron los datos del personaje", Toast.LENGTH_SHORT).show()

            }

        btnConsultar.setOnClickListener{
            val admin = AdminSQLiteOpenHelper(this, "personajes", null, 1)
            val db = admin.writableDatabase
            val row = db.rawQuery("select * from personajes", null)
            if (row.moveToFirst()){
                charName.setText(row.getString(0))
                charType.setText(row.getString(1))
                charKarma.setText(row.getString(2))
            }
            }

    }

}




