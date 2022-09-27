package com.example.fitness

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class inicio : AppCompatActivity() {

    /*val sesion2 = findViewById <Button> ( R.id.sesion2 )
    val email = findViewById<EditText>(R.id.email)
    val password = findViewById<EditText>(R.id.password)*/
    val atras = findViewById<Button>(R.id.atras)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        atras.setOnClickListener {
            val regresar = Intent(this, MainActivity::class.java)
            startActivity(regresar)
        }
        /*sesion2.setOnClickListener {
            if (email.equals("bryan@gmail.com") && password.equals("2468")) {
                val lanzar2 = Intent(this, principal::class.java)
                startActivity(lanzar2)
            } else {
                Toast.makeText(
                    this@inicio, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT
                ).show()
            }
        }*/
    }
}



