package com.example.listacontactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() , IClickListenerProducto {
    val datos: ArrayList<Producto> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datosFalsos()
        var recycler: RecyclerView = findViewById(R.id.listaproductos)
        recycler.setHasFixedSize(true)
        val adaptador = Adaptador(this, datos, this)
        recycler.adapter= adaptador
    }
    fun datosFalsos(){
        datos.add(Producto("Producto1","$55"))
        datos.add(Producto("Producto2", "$100"))
        datos.add(Producto("Producto3", "$80"))
        datos.add(Producto("Producto4", "$150"))
        datos.add(Producto("Producto5", "$200"))
        datos.add(Producto("Producto6", "$120"))
    }

    override fun onCellClickListener(producto: Producto) {

        Log.e("Producto","Se presiono a: ${producto.nombreProducto}")
    }
}