package com.example.camapp

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaramos las vistas
    private lateinit var ivFoto: ImageView
    private lateinit var btnGaleria: Button
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            ivFoto.setImageURI(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ivFoto = findViewById(R.id.ivFoto)
        btnGaleria = findViewById(R.id.btnGaleria)

        btnGaleria.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}