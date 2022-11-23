package com.example.pac


import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast


class Activity3 : AppCompatActivity() {

    lateinit var btnActivity1: Button
    lateinit var btnCamera: Button
    val REQUEST_CAMERA_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

        btnActivity1 = findViewById(R.id.buttonActivity)

        btnCamera = findViewById(R.id.buttonCamera)

        btnActivity1.setOnClickListener{
            val goToActivity1 = Intent(this, MainActivity::class.java)
            startActivity(goToActivity1)

        }

        funOpenCamera()

        }

        private fun camera(){
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val value = ContentValues()
            startActivityForResult(cameraIntent, REQUEST_CAMERA_CODE)
        }

       private fun funOpenCamera(){
           btnCamera.setOnClickListener(){
               if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                   if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                       val cameraPermission = arrayOf(android.Manifest.permission.CAMERA)
                       requestPermissions(cameraPermission, REQUEST_CAMERA_CODE)
                   }else{
                       camera()
                   }
               }
           }
       }
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CAMERA_CODE->{
                //si el permiso está concecido se abre la cámara
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    camera()
            }
        }
    }


}



