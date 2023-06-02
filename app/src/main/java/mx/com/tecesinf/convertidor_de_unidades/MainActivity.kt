package mx.com.tecesinf.convertidor_de_unidades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn_acerca : Button
    lateinit var btn_temperatura : Button
    lateinit var btn_pulgadas : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_acerca = findViewById(R.id.btn_acerca)
        btn_temperatura = findViewById(R.id.btn_invertir)
        btn_pulgadas = findViewById(R.id.btn_convertir_temperatura)

        btn_acerca.setOnClickListener {
            val acerca = Intent(this, Acerca_de::class.java) //Inicializa la vista de aceca de
            startActivity(acerca)
        }

        btn_temperatura.setOnClickListener {
            val temperatura = Intent(this, Convertidor_Temperatura::class.java) //Abre la vista de conversion de temperaturaS
            startActivity(temperatura)
        }

        btn_pulgadas.setOnClickListener {
            val pulgadas = Intent(this, convertidor_de_pulgadas::class.java) // ABRE LA VISTA DE CONVERSION DE MTROA A PULGADA
            startActivity(pulgadas)
        }
    }
}