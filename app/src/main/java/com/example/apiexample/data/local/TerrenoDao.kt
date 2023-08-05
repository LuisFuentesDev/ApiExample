package com.example.apiexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TerrenoDao {
    @Insert
    suspend fun insertarTerreno(terrenoEntity: TerrenoEntity)

    @Query("SELECT * FROM tabla_terreno order by id ASC")

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>>

}