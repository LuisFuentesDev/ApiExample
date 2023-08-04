package com.example.apiexample.data

import com.example.apiexample.data.remote.Terreno
import com.example.apiexample.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {

    suspend fun cargarTerreno(): List<Terreno> {
        val respuesta = terrenoAPI.getData()
        if (respuesta.isSuccessful) {
            val resp = respuesta.body()
            resp?.let {
                return it
            }
        }
        return emptyList()
    }
}