package com.example.supermercado

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivityPerecederos : AppCompatActivity() {
    private val sharedP=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perecederos)

        val codigo2 = findViewById<EditText>(R.id.txtCodigo2)
        val desc2 = findViewById<EditText>(R.id.txtDesc2)
        val precio2 = findViewById<EditText>(R.id.txtPrecio2)
        val dias = findViewById<EditText>(R.id.txtDias)
        val nuevoValor = findViewById<EditText>(R.id.txtNuevoValor)

        val calcular = findViewById<Button>(R.id.btnCalcular)
        val crear2 = findViewById<Button>(R.id.btnCrear2)
        val consultar2 = findViewById<Button>(R.id.btnConsultar2)

        val sp = getSharedPreferences(codigo2.text.toString(), Context.MODE_PRIVATE)


        codigo2.setText(intent.getStringExtra("codigo"))
        desc2.setText(intent.getStringExtra("desc"))
        precio2.setText(intent.getStringExtra("precio"))

        calcular.setOnClickListener(){
            var precioFinal=0

            if(dias.toString().toInt()==1){
                precioFinal = precio2.toString().toInt() / 4
                nuevoValor.setText(precioFinal)
            }
            else if(dias.toString().toInt()==2){
                precioFinal = precio2.toString().toInt() / 3
                nuevoValor.setText(precioFinal)
            }
            else if(dias.toString().toInt()==3){
                precioFinal = precio2.toString().toInt() / 2
                nuevoValor.setText(precioFinal)
            }

        }

        crear2.setOnClickListener(){
            val editor = sp.edit()
            editor.putString("codigo2", codigo2.text.toString())
            editor.putString("desc2", desc2.text.toString())
            editor.putString("precio2", precio2.text.toString())
            editor.putString("dias", dias.text.toString())
            editor.putString("nuevoValor", nuevoValor.text.toString())
            editor.apply()
            Toast.makeText(this,"Datos guardados", Toast.LENGTH_LONG).show()
            codigo2.setText("")
            desc2.setText("")
            precio2.setText("")
            dias.setText("")
            nuevoValor.setText("")

        }

        consultar2.setOnClickListener(){
            var buscar=codigo2.text.toString()
            var sp = getSharedPreferences(buscar, Context.MODE_PRIVATE)


                var codigo=sp.getString("codigo2", "")
                var desc=sp.getString("desc2", "")
                var precio=sp.getString("precio2", "")

               if(codigo!!.length){
                   codigo2.setText(codigo)
                   desc2.setText(desc)
                   desc2.setText(precio)
                   Toast.makeText(this,"Datos encontrados", Toast.LENGTH_LONG).show()
               }else{
                   Toast.makeText(this,"No se han encontrado los datos", Toast.LENGTH_LONG).show()
               }




        }

    }
}