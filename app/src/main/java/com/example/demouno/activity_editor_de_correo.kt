package com.example.demouno

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class activity_editor_de_correo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //se crea la vista
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor_de_correo)

        //y hace una liga hacia el campo de vición
        val campoDeEdicion = findViewById<EditText>(R.id.CorreoNuevo)
        //recibe lo que escribe el usuario y lo extrae
        campoDeEdicion.setText(intent.getStringExtra("STRING_ANTERIOR"))
    }

    //Funciones para los botones creados en esta vista
    @Suppress("UNUSED_PARAMETER")
    fun OK(unBoton: View){
        val nuevoString = findViewById<EditText>(R.id.CorreoNuevo).text.toString()
        //se crea un intent vacio para poder regresar los datos que se hayan obtenido en este caso
        val datos = Intent().apply {
            putExtra("SRING_NUEVO", nuevoString)
        }
        setResult(Activity.RESULT_OK, datos)
        finish()
    }

    @Suppress("UNUSED_PARAMETER")
    fun cancelar(unBoton: View){
        //cse cancela el resultado
        setResult(Activity.RESULT_CANCELED)
        //con el finish dada la redundancia indica que se ha terminado y regresa a doonde se llamo
        finish()
    }

    //Este companion es para que nuestro codigo pueda ser modular y ayude a la reutilización de código
    companion object{
        //crea el intento que rcordemos que se llena con por decirlo así con los parametros en donde se piden las cosas
        //con en donde estan y todos los extras que se mandan de el
        //Y justo este intent es el que queremos encapsular por lo tanto se busca hacerlo lo más generico posible
        fun nuevoIntent(contexto: Context, stringAEditar:String) : Intent{
            return Intent(contexto, activity_editor_de_correo::class.java).apply {
                putExtra("STRING_ANTERIOR", stringAEditar)
            }
        }
    }
}