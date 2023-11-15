package com.example.supermercado

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Switch



class MainActivity : AppCompatActivity() {
    private val sharedP = ""

    private lateinit var switch: Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigo = findViewById<EditText>(R.id.txtCodigo)
        val desc = findViewById<EditText>(R.id.txtDesc)
        val precio = findViewById<EditText>(R.id.txtPrecio)

        val crear = findViewById<Button>(R.id.btnCrear)
        val switch = findViewById<Switch>((R.id.txtPerecederos))

        var sp = getSharedPreferences(codigo.text.toString(), Context.MODE_PRIVATE)

        crear.setOnClickListener(){
            val editor = sp.edit()
            editor.putString("codigo", codigo.text.toString())
            editor.putString("desc", desc.text.toString())
            editor.putString("precio", precio.text.toString())
            editor.commit()
            Toast.makeText(this,"Datos guardados", Toast.LENGTH_LONG).show()
            codigo.setText("")
            desc.setText("")
            precio.setText("")

            if (switch.isChecked) {
                val enviarCodigo:String = codigo.text.toString()
                val enviarDesc:String = desc.text.toString()
                val enviarPrecio:String = precio.text.toString()
                val Perecen = Intent(this@MainActivity, ActivityPerecederos::class.java)
                Perecen.putExtra("codigo", enviarCodigo)
                Perecen.putExtra("desc", enviarDesc)
                Perecen.putExtra("precio", enviarPrecio)
                startActivity(Perecen)

            } else {
                val noPerecen = Intent(this@MainActivity, ActivityNoPerecederos::class.java)
                startActivity(noPerecen)

            }

        }






}
}