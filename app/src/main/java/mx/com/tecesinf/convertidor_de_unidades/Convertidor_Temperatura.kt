package mx.com.tecesinf.convertidor_de_unidades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Convertidor_Temperatura : AppCompatActivity() {
//SE INICIAN LAS VARIABLES A UTLIZAR
    lateinit var btn_convertir : Button
    lateinit var btn_invertir : Button
    lateinit var btn_limpiar : Button
    lateinit var atras : Button
    lateinit var lb_undidad_a_covertir : TextView
    lateinit var lb_unidadResultado  : TextView
    lateinit var lb_resultado  : TextView
    lateinit var txt_cantidad : EditText

    var invertir : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convertidor_temperatura)
//SE HACEN RELACIONES DE LOS COMPONENTES DE LA VISTA
         btn_convertir = findViewById(R.id.btn_convertir_temperatura)
         atras = findViewById(R.id.btn_atras_temp)
         btn_invertir = findViewById(R.id.btn_invertir)
         btn_limpiar = findViewById(R.id.btn_limpiar)
         lb_undidad_a_covertir = findViewById(R.id.lb_undidad_a_covertir)
         lb_unidadResultado= findViewById(R.id.lb_unidadResultado_temperatura)
         lb_resultado= findViewById(R.id.lb_resultado_temperatura)
         txt_cantidad= findViewById(R.id.txt_cantidad_temperatura)

        //SE REALIZAN LOS EVENTOS QUE REALIZARAN  LOS BOTONES
        btn_convertir.setOnClickListener {
            if(txt_cantidad.text.toString().equals("")){
                txt_cantidad.text=Editable.Factory.getInstance().newEditable("0")
            }
            if(invertir){
                convertirFahreheitToCelsio()

            }else{
                convertirCelsioToFahreheit()
            }
        }

        btn_invertir.setOnClickListener {
            if(txt_cantidad.text.toString().equals("")){ //VERIFICA QUE NO LLEGE VALORES NULL
                txt_cantidad.text=Editable.Factory.getInstance().newEditable("0")
            }
            if(invertir){ // CAMBIA EL TIPO DE CONVERSION
                invertir = false
                lb_undidad_a_covertir.text = "Celsius"
                lb_unidadResultado.text = "Fahrenheit"
                convertirCelsioToFahreheit()
            }else{
                lb_undidad_a_covertir.text = "Fahrenheit"
                lb_unidadResultado.text = "Celsius"
                invertir = true
                convertirFahreheitToCelsio()
            }
        }
        btn_limpiar.setOnClickListener {//LIMBIA LOS CAMPOS
            limpiar()
        }
        atras.setOnClickListener {//REGRESA AL MENU
            val main = Intent(this, MainActivity::class.java)
            startActivity(main)
        }
    }

    private fun convertirFahreheitToCelsio() { //HACE LA CONVERSION
        var valorIngresado = txt_cantidad.text.toString().toFloat()
        var constante = 1.8
        var resultado = ((valorIngresado - 32) / constante)
        lb_resultado.text = ""+resultado
    }

    private fun convertirCelsioToFahreheit() {//HACE LA CONVERSION
        var valorIngresado = txt_cantidad.text.toString().toFloat()
        var constante = 1.8
        var resultado = ((constante * valorIngresado) +32)
        lb_resultado.text = ""+resultado
    }

    private fun limpiar() { // LIMPIA CAMPOS
        lb_resultado.text = ""
        txt_cantidad.text = Editable.Factory.getInstance().newEditable("")
        txt_cantidad.requestFocus()
    }
}