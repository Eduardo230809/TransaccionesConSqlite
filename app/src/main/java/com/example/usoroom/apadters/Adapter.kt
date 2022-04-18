package com.example.usoroom.apadters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.usoroom.Entities.ClasificacionEntity
import com.example.usoroom.R
import kotlinx.android.synthetic.main.item_clasificacion.view.*


class Adapter (private val mContext: Context, private val lista:List<ClasificacionEntity>):
    ArrayAdapter<ClasificacionEntity>(mContext, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_clasificacion, parent, false)


        val c = lista[position]

        val descripcion: String = c.nombre
        val abreviaciom: String = c.abreviacion

        layout.TvNombre.text= "Descripcion:" + "\n" + "$descripcion"
        layout.TvAbreviacion.text = "Abreviacion:"+ "\n" +"$abreviaciom"
        layout.TvId.text = c.idClasificacion.toString()


        return layout
    }
}