package com.example.usoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usoroom.Entities.ClasificacionEntity
import com.example.usoroom.databinding.ActivityAgregarCBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AgregarC : AppCompatActivity() {
    private lateinit var binding : ActivityAgregarCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarCBinding.inflate(layoutInflater)
        setContentView(binding.root)

        add()
    }

    private fun add() {


        binding.BtnSave.setOnClickListener {


            val abreviacion = binding.TvAbreviacion.text.toString()
            val nombre = binding.TvNombre.text.toString()


            val pl = ClasificacionEntity( abreviacion, nombre)

            val db = MainDataBase.getInstace(this)

            CoroutineScope(Dispatchers.IO).launch {

                val id = db.clasificacionDao().insert(pl)[0]


                this@AgregarC.finish()
            }


        }
    }
}