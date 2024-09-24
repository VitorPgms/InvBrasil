package com.example.invbrasil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val data = ArrayList<String>()
    private val data1 = ArrayList<String>()
    private val data2 = ArrayList<String>()
    private val data3 = ArrayList<String>()
    private val data4 = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pname = findViewById(R.id.editText1) as EditText
        val price = findViewById(R.id.editText2) as EditText
        val qt = findViewById(R.id.editText3) as EditText
        val color = findViewById(R.id.editText4) as EditText

        val subtotal = findViewById(R.id.editText5) as EditText

        val btn = findViewById(R.id.btnAdd) as Button

        btn.setOnClickListener{
            val pnames = pname.text.toString()
            val prices = price.text.toString().toInt()
            val qty = qt.text.toString().toInt()
            val colors = color.text.toString()

            val total = prices * qty

            data.add(pnames)
            data1.add(prices.toString())
            data2.add(qty.toString())
            data3.add(colors)
            data4.add(total.toString())

            val table = findViewById(R.id.tabela) as TableLayout

            val row = TableRow(this)
            val t1 = TextView(this)
            val t2 = TextView(this)
            val t3 = TextView(this)
            val t4 = TextView(this)
            val t5 = TextView(this)

            var tot: String
            var sum = 0

            for(i in data.indices){
                val pn = data[i]
                val pr = data1[i]
                val qtt = data2[i]
                val cor = data3[i]
                val tt = data4[i]

                t1.text = pn
                t2.text = pr
                t3.text = qtt
                t4.text = cor
                t5.text = tt

                sum = sum + Integer.parseInt(data4[i])
            }

            row.addView(t1)
            row.addView(t2)
            row.addView(t3)
            row.addView(t4)
            row.addView(t5)
            table.addView(row)

            subtotal.setText(sum.toString())
            pname.setText("")
            price.setText("")
            qt.setText("")
            color.setText("")


        }




    }
}