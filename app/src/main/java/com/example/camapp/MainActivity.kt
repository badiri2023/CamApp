package com.example.camapp
import android.graphics.Bitmap
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
    private lateinit var btnCamera: Button

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            ivFoto.setImageURI(uri)
        }
    }

    private val takePicturePreview = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
        if (bitmap != null) {
            ivFoto.setImageBitmap(bitmap)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Vinculem les vistes
        ivFoto = findViewById(R.id.ivFoto)
        btnGaleria = findViewById(R.id.btnGaleria)
        btnCamera = findViewById(R.id.btnCamera)

        // Listener del botó Galeria
        btnGaleria.setOnClickListener {
            getContent.launch("image/*")
        }

        // Listener del botó Càmera
        btnCamera.setOnClickListener {
            takePicturePreview.launch(null)
        }
    }
}