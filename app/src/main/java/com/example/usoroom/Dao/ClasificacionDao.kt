package com.example.usoroom.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.usoroom.Entities.ClasificacionEntity

@Dao
interface ClasificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert( vararg clasificacion: ClasificacionEntity):List<Long>

    @Query("Select * from TblClasificacion where idClasificacion = :id")
     fun getById(id:Int):LiveData<ClasificacionEntity>

    @Query("SELECT * FROM TblClasificacion")
     fun getAll(): LiveData<List<ClasificacionEntity>>

    @Update
    fun update(clasificacion: ClasificacionEntity)

    @Delete
    fun delete(clasificacion: ClasificacionEntity)

}