package com.example.apiexample.data

import androidx.lifecycle.LiveData
import com.example.apiexample.data.local.TerrenoDao
import com.example.apiexample.data.local.TerrenoEntity
import com.example.apiexample.data.remote.Terreno
import com.example.apiexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.obtenerTerrenos()
    suspend fun cargarTerreno() {
        val respuesta = terrenoAPI.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let {

            }
        }

    }
}