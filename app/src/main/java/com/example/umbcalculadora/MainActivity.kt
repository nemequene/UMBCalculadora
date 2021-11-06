/* -----------------------------------
Néstor Rodríguez Cartagena
Programación en Plataformas Móviles I
Actividad 5 - Desarrollo Calculadora
Universidad Manuela Bletrán
Noviembre de 2021
-------------------------------------- */

package com.example.umbcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numA: Double = 0.0
    private var numB: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn0.setOnClickListener{ entrarNumero(tecla = "0") }
        btn1.setOnClickListener{ entrarNumero(tecla = "1") }
        btn2.setOnClickListener{ entrarNumero(tecla = "2") }
        btn3.setOnClickListener{ entrarNumero(tecla = "3") }
        btn4.setOnClickListener{ entrarNumero(tecla = "4") }
        btn5.setOnClickListener{ entrarNumero(tecla = "5") }
        btn6.setOnClickListener{ entrarNumero(tecla = "6") }
        btn7.setOnClickListener{ entrarNumero(tecla = "7") }
        btn8.setOnClickListener{ entrarNumero(tecla = "8") }
        btn9.setOnClickListener{ entrarNumero(tecla = "9") }

        btnSumar.setOnClickListener{ entrarOperacion(SUMA) }
        btnRestar.setOnClickListener{ entrarOperacion(RESTA) }
        btnDividir.setOnClickListener{ entrarOperacion(DIVISION) }
        btnMultiplicar.setOnClickListener{ entrarOperacion(MULTIPLICACION) }

        btnBorrar.setOnClickListener {
            numA = 0.0
            numB = 0.0
            txvSalida.text = "0"
            operacion = NO_OPERACION
        }

        btnResultado.setOnClickListener{
            var resultado = when(operacion){
                SUMA -> numA + numB
                RESTA -> numA - numB
                MULTIPLICACION -> numA * numB
                DIVISION -> numA / numB
                else -> 0
            }
            txvSalida.text = resultado.toString()
        }

    }

    private fun entrarNumero(tecla: String){
        if(txvSalida.text.toString().toDouble() == 0.0){
            txvSalida.text = "$tecla"
        }else{
            txvSalida.text = "${txvSalida.text}$tecla"
        }

        if(operacion == NO_OPERACION){
            numA = txvSalida.text.toString().toDouble()
        } else {
            numB = txvSalida.text.toString().toDouble()
        }

    }

    private fun entrarOperacion(operacion: Int){
        this.operacion = operacion
        txvSalida.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }

}