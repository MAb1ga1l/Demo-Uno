package com.example.demouno

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

//El objetivo principald e esta demo es entender como se pasa la información de un lado a otro
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Aqui se alambra la función al boton
    //el suppress es para eliminar el warning de que la variable de buttonEditar no se esta utilizando dentro de la función
    @Suppress("UNUSED_PARAMETER")
    fun editarCorreo(buttonEditar:View){
        //detecta y extrae el valor que se encuentra en campoMAil
        val campoDeTexto = findViewById<TextView>(R.id.campoMail)
        val correoActual = campoDeTexto.text.toString()
        //ya solo se solicita el contexto y el string que se quiere cambiar
        val intent = activity_editor_de_correo.nuevoIntent(this, correoActual)
        //con esto se inicia la transición a la otra actividad
        //startActivity(intent)
        //Este de foma muy sencilla es que creará un intento que obtendra algo y en cuanto termine regresará
        startActivityForResult(intent,0)
    }

    //recive que intent se uso, que codigo resolvio y los datos
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0){
            if(resultCode == Activity.RESULT_CANCELED){
                return
            }
            val correoRecibido = data?.getStringExtra("SRING_NUEVO")
            findViewById<TextView>(R.id.campoMail).text=correoRecibido
        }
    }
}