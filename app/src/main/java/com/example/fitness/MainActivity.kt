package com.example.fitness

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView
import android.net.Uri
import android.widget.Button


class MainActivity: AppCompatActivity() {

    //declaracion de variable para el video de fondo
    protected lateinit var vv_fondo: VideoView
    protected lateinit var mMediaPlayer: MediaPlayer
    protected var mCurrentVideoPosition: Int = 0

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val boton1 = findViewById < Button > ( R.id.sesion )
            boton1.setOnClickListener {
                val lanzar = Intent (this , inicio :: class.java )
                startActivity ( lanzar )
            }

            //video de fondo
        vv_fondo= findViewById(R.id.videoView)
        val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.video1)
        vv_fondo.setVideoURI(uri)
        vv_fondo.start()
        vv_fondo.setOnPreparedListener { mp ->
            mMediaPlayer = mp
            mMediaPlayer.isLooping = true
            if (mCurrentVideoPosition != 0) {
                mMediaPlayer.seekTo(mCurrentVideoPosition)
                mMediaPlayer.start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mCurrentVideoPosition = mMediaPlayer.currentPosition
        vv_fondo.pause()
    }
    override fun onResume() {
        super.onResume()
        vv_fondo.start()
    }
    override fun onDestroy() {
        super.onDestroy()

        mMediaPlayer.release()
    }
}