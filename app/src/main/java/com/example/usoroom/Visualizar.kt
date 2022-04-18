package com.example.usoroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.usoroom.Entities.ClasificacionEntity
import kotlinx.android.synthetic.main.activity_visualizar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Visualizar : AppCompatActivity() {
    private lateinit var  db : MainDataBase
    private lateinit var c : ClasificacionEntity
    private lateinit var liveData : LiveData<ClasificacionEntity>
    var id:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        db = MainDataBase.getInstace(this)

        id = intent.getIntExtra("idClasificacion", 0)

        liveData = db.clasificacionDao().getById(id)

        liveData.observe(this, Observer {
            c = it
            val descripcion: String = c.nombre
            val abreviaciom: String = c.abreviacion
            val id: String = c.idClasificacion.toString()
            val estado = c.activo.toString()
            var estado2:String

            if(estado == "true"){
                estado2 = "Activo"
            }else{
                estado2 = "Inactivo"
            }

            VNombre.text = "Descripcion: $descripcion"
            VAbreviacion.text = "Abreviacion: $abreviaciom"
            VId.text = "ID: $id"
            VEstado.text = "Estado: $estado2"
        })

    }
}