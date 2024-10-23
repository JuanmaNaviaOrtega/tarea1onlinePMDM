package com.example.tarea1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hacer las referencias a los elementos del layout
        val numberInput = findViewById<EditText>(R.id.numberInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        //Crear accion del botton
        calculateButton.setOnClickListener {
            //Obtener el texto del EditText

            val inputText = numberInput.text.toString()
            //Convertir el texto del EditText a un int
            try {
                val numero = inputText.toInt()

                //Crear un if por si el numero es menor o igual que 0, introduzcamos un numero positvo mayor
                if (numero <= 0) {
                    textViewResultado.text = "Introduce un numero positivo mayor que 0"
                } else {
                    val siguientePrimo = siguientePrimo(numero)
                    textViewResultado.text = "El siguiente número primo es: $siguientePrimo"
                }

            } catch (e: NumberFormatException) {
                //Si el dato no es un numero
                textViewResultado.text = "Por favor introduce un número valido"
            }
        }
    }
}
    //funcion para comprobar si un numero es primo
    fun esprimo(n:Int):Boolean{
        if (n<2)return false
        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if(n % i ==0) return false
        }
        return true
    }

    fun siguientePrimo(num:Int):Int{
        var candidato = num +1
        while(!esprimo(candidato)){
            candidato++
        }
        return candidato
    }
