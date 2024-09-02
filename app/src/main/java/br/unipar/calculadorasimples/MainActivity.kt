package br.unipar.calculadorasimples

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.labelNum2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputNum1 = findViewById<EditText>(R.id.editNum1)
        val inputNum2 = findViewById<EditText>(R.id.editNum2)
        val labelResultado = findViewById<TextView>(R.id.labelResultado)
        val btnSomar = findViewById<Button>(R.id.btnSomar)
        val btnSubtrair = findViewById<Button>(R.id.btnSubtrair)

        btnSomar.setOnClickListener {
            val num1 = inputNum1.text.toString()
            val num2 = inputNum2.text.toString()

            if (num1.isNotEmpty() and num2.isNotEmpty()) {
                val resultado: Float = (num1.toFloat()) + (num2.toFloat())
                labelResultado.setText("Resultado: $resultado")
            } else {
                labelResultado.setText("Digite dois números válidos!")
            }
        }

        btnSubtrair.setOnClickListener {
            val num1 = inputNum1.text.toString()
            val num2 = inputNum2.text.toString()

            if (num1.isNotEmpty() and num2.isNotEmpty()) {
                val resultado = num1.toFloat() - num2.toFloat()
                labelResultado.setText("Resultado: $resultado")
            } else {
                labelResultado.setText("Digite dois números válidos!")
            }
        }


    }

}