package com.example.apiexample.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apiexample.data.Repositorio
import com.example.apiexample.data.local.TerrenoDatabase
import com.example.apiexample.data.remote.Terreno
import com.example.apiexample.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio
    fun terrenosLiveData() = repositorio.obtenerTerrenos()

    init {
        val terrenoApi = TerrenoRetroFit.getRetrofitTerreno()
        val terrenoBaseDatos = TerrenoDatabase.getDataBase(application).getITerrenoDao()
        repositorio = Repositorio(terrenoApi, terrenoBaseDatos)

    }

    fun getAllTerrenos() = viewModelScope.launch {
        repositorio.cargarTerreno()

    }
}