package com.example.appfootball.Clases

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appfootball.MainActivity
import com.example.appfootball.R

class Inicio : AppCompatActivity() {

    val url ="https://mir-s3-cdn-cf.behance.net/project_modules/disp/11284728357073.56373a378d4a2.gif"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_carga_inicio)
        supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 2000, )

        val imagenGif = findViewById<ImageView>(R.id.Gif)
        Glide.with(this).load(url).into(imagenGif)

    }

}