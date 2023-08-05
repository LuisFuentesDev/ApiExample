package com.example.apiexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TerrenoDao {
    @Insert
    suspend fun insertarTerreno(terrenoEntity: TerrenoEntity)
    @Insert
    suspend fun insertarTerrenos(terrenosEntity: List<TerrenoEntity>)


    @Query("SELECT * FROM tabla_terreno order by id ASC")

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>

}