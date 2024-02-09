package mx.edu.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operacion: Int = 0
    var numero1: Int = 0

    lateinit var tv1: TextView
    lateinit var tv2: TextView
    lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResultado: Button = findViewById(R.id.btnResultado)
        val btnBorrar: Button = findViewById(R.id.btnBorrar)

        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        tvError = findViewById(R.id.tvError)

        btnResultado.setOnClickListener{
            val numero2 = tv2.text.toString().toInt()
            var res = 0

            if (operacion == 4 && numero2 == 0) {
                tvError.text="Error: división por cero."
            } else {
                when(operacion){
                    1 -> res = numero1 + numero2
                    2 -> res = numero1 - numero2
                    3 -> res = numero1 * numero2
                    4 -> res = numero1 / numero2
                }
                tv2.setText("")
                tv1.setText(res.toString())
            }
        }

        btnBorrar.setOnClickListener{
            tv1.setText("")
            tv2.setText("")
            operacion = 0
        }

    }

    fun clickNumero(view: View){
        val numero = (view as Button).text.toString()
        var numero2 = tv2.text.toString()
        numero2 += numero
        tv2.setText(numero2)
    }

    fun realizarOperacion(view: View){
        val numero2 = tv2.text.toString()
        numero1 = numero2.toInt()
        tv2.setText("")
        tv1.text = when(view.id){
            R.id.btnSumar -> "$numero2+"
            R.id.btnRestar -> "$numero2-"
            R.id.btnMultiplicar -> "$numero2*"
            R.id.btnDividir -> "$numero2/"
            else -> ""
        }
        operacion = when(view.id){
            R.id.btnSumar -> 1
            R.id.btnRestar -> 2
            R.id.btnMultiplicar -> 3
            R.id.btnDividir -> 4
            else -> 0
        }
    }
}