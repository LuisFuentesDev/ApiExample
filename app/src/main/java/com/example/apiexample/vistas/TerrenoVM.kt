package com.example.apiexample.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apiexample.data.Repositorio
import com.example.apiexample.data.remote.Terreno
import com.example.apiexample.data.remote.TerrenoRetroFit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application) : AndroidViewModel(application) {
    private val repositorio: Repositorio
    val terrenosLiveData = MutableLiveData<List<Terreno>>()

    init {
        val api = TerrenoRetroFit.getRetrofitTerreno()
        repositorio = Repositorio(api)

    }

    fun getAllTerrenos() = viewModelScope.launch {
        terrenosLiveData.value = repositorio.cargarTerreno()

    }
}