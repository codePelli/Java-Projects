package com.example.pac

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnPlay : Button
    lateinit var btnStop : Button
    lateinit var btnActivity2: Button
    lateinit var btnActivity3: Button
    lateinit var btnActivity4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mp = MediaPlayer.create(this, R.raw.dbz)

        //Activity 1 buttons
        btnActivity2 = findViewById(R.id.buttonActivity2)
        btnActivity3 = findViewById(R.id.buttonActivity3)
        btnActivity4 = findViewById(R.id.buttonActivity4)

        //Activity button functions from Activity1
        btnActivity2.setOnClickListener{
            val saludo= "Estás en el activity 2!"
            val goToActivity2 = Intent(this, Activity2::class.java)
            goToActivity2.putExtra("hola", saludo)
            mp.stop()
            mp.release()
            startActivity(goToActivity2)
        }
        btnActivity3.setOnClickListener{
            val goToActivity3 = Intent(this, Activity3::class.java)
            startActivity(goToActivity3)
            mp.stop()
            mp.release()
        }
        btnActivity4.setOnClickListener{
            val goToActivity4 = Intent(this, Activity4::class.java)
            startActivity(goToActivity4)
            mp.stop()
            mp.release()
        }

        //Activity 1 multimedia
        btnPlay = findViewById(R.id.btnPlay)
        btnStop = findViewById(R.id.btnStop)

        btnPlay.setOnClickListener{
            mp.start()
        }
        btnStop.setOnClickListener{
            if(mp.isPlaying)
            mp.stop()
            mp = MediaPlayer.create(this, R.raw.dbz)
        }


    }
}