package com.example.usoroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.usoroom.Dao.ClasificacionDao
import com.example.usoroom.Entities.ClasificacionEntity


@Database(entities = [ClasificacionEntity::class],
    version =1
)
abstract class MainDataBase: RoomDatabase(){
    abstract fun clasificacionDao(): ClasificacionDao
    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getInstace(context: Context):MainDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "clasificacion_main_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
