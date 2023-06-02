package mx.com.tecesinf.convertidor_de_unidades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Acerca_de : AppCompatActivity() {
    lateinit var atras : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)
        atras = findViewById(R.id.btn_atras_acerca)

        atras.setOnClickListener {// REGRESA A LA VISTA PRINCIPAL (MENU)
            val main = Intent(this, MainActivity::class.java)
            startActivity(main)
        }
    }
}