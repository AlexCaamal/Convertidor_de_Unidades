package mx.com.tecesinf.convertidor_de_unidades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class convertidor_de_pulgadas : AppCompatActivity() {

    // Variables que en un futuro se usaran
    lateinit var btn_convertir : Button
    lateinit var btn_invertir : Button
    lateinit var btn_limpiar : Button
    lateinit var lb_undidad_a_covertir : TextView
    lateinit var lb_unidadResultado  : TextView
    lateinit var lb_resultado  : TextView
    lateinit var txt_cantidad : EditText
    lateinit var atras : Button
    var invertir : Boolean = false


    // Constructor, en donde se inicializa todo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convertidor_de_pulgadas)

        //Las variables que se inicializaron, se relaciona con los componentes que se tiene en la vista
        btn_convertir = findViewById(R.id.btn_convertir_Metro)
        atras = findViewById(R.id.btn_atras)
        btn_invertir = findViewById(R.id.brtn_invertir_metro)
        btn_limpiar = findViewById(R.id.btn_limpiar)
        lb_undidad_a_covertir = findViewById(R.id.lb_cant_digitar)
        lb_unidadResultado= findViewById(R.id.lb_result_metro)
        lb_resultado= findViewById(R.id.lb_resultadoMetro)
        txt_cantidad= findViewById(R.id.txt_metro)

        // Inicio de eventos para los botones
        btn_convertir.setOnClickListener {
            if(txt_cantidad.text.toString().equals("")){ // Si el txt en donde coloca la cantidad es nulo, lo convertira en cero
                txt_cantidad.text=Editable.Factory.getInstance().newEditable("0")
            }
            if(invertir){ // Verifica en que tipo de conversion esta
                convertirMetrosToPulgada() // en este caso debe estar en pulgadas a metros
            }else{
                convertirPulgadaToMetro() // en este caso debe estar en Metros a Pulgadas
            }
        }

        btn_invertir.setOnClickListener { // Cambia la conversion.
            if(txt_cantidad.text.toString().equals("")){// Si el txt en donde coloca la cantidad es nulo, lo convertira en cero
                txt_cantidad.text=Editable.Factory.getInstance().newEditable("0")
            }
            if(invertir){ //Invierte la conversion, si estaba en pulgadas a metros, lo cambia a metros a pulgadas
                invertir = false //Invierte la conversion mediante esta variable, si esta en falso lo cambia a Pulgadas a Metros
                lb_undidad_a_covertir.text = "Pulgadas"
                lb_unidadResultado.text = "Metros"
                convertirPulgadaToMetro()
            }else{
                lb_undidad_a_covertir.text = "Metros"
                lb_unidadResultado.text = "Pulgadas"
                invertir = true//Invierte la conversion mediante esta variable, si esta en falso lo cambia a Metros a Pulgadas
                convertirMetrosToPulgada()
            }
        }
        btn_limpiar.setOnClickListener {//Limpia los campos
            limpiar()
        }
        atras.setOnClickListener {/// Regresa a la vista anterior
            val main = Intent(this, MainActivity::class.java)
            startActivity(main)
        }
    }

    private fun convertirMetrosToPulgada() {//Hace el calculo de la conversion
        var valorIngresado = txt_cantidad.text.toString().toFloat()
        var constante = 39.3701
        var resultado = (valorIngresado * constante)
        lb_resultado.text = ""+resultado
    }

    private fun convertirPulgadaToMetro() {//Hace el calculo de la conversion
        var valorIngresado = txt_cantidad.text.toString().toFloat()
        var constante = 100
        var resultado = ((constante / valorIngresado) +32)
        lb_resultado.text = ""+resultado
    }

    private fun limpiar() {//Limpia los campos
        lb_resultado.text = ""
        txt_cantidad.text = Editable.Factory.getInstance().newEditable("")
        txt_cantidad.requestFocus()
    }
}