package com.example.listacontactos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador(context: Context, private var datos:ArrayList<Producto>,
private var celdaClick: IClickListenerProducto):
RecyclerView.Adapter<Adaptador.ViewHolderElemento>() {
    class ViewHolderElemento (itemView: View):
            RecyclerView.ViewHolder(itemView){
        var txtNombreProducto: TextView= itemView.findViewById(R.id.txt_NombreProducto)
        var txtPrecio: TextView= itemView.findViewById(R.id.txt_Precio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderElemento {
       val itemProducto = LayoutInflater.from(parent.context).inflate(R.layout.item_produto,parent,
       false)
        return  ViewHolderElemento(itemProducto)

    }

    override fun onBindViewHolder(holder: ViewHolderElemento, position: Int) {
       val itemActual = datos[position]
        holder.txtNombreProducto.text = itemActual.nombreProducto
        holder.txtPrecio.text= itemActual.precio
        holder.itemView.setOnClickListener{celdaClick.onCellClickListener(itemActual)}
    }
    override fun getItemCount(): Int = datos.size
}