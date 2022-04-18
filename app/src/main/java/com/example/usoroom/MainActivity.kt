package com.example.usoroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.usoroom.Entities.ClasificacionEntity
import com.example.usoroom.apadters.Adapter
import com.example.usoroom.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            iniciar()
    }


    fun iniciar(){
        var lista = emptyList<ClasificacionEntity>()
        val bd  = MainDataBase.getInstace(this)

        bd.clasificacionDao().getAll().observe(this, Observer {
            lista = it
            val adapter = Adapter(this, lista )
            LvC.adapter = adapter
        })

        LvC.setOnItemClickListener() { parent, view, position, id ->
            val intent = Intent(this, Visualizar::class.java)
            intent.putExtra("idClasificacion", lista[position].idClasificacion)
            startActivity(intent)

        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.Agregar -> {
                val intent = Intent(this, AgregarC::class.java)
                startActivity(intent)
            }

        }

        return super.onOptionsItemSelected(item)
    }
}