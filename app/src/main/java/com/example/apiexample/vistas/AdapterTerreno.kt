package com.example.apiexample.vistas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiexample.R
import com.example.apiexample.data.local.TerrenoEntity
import com.example.apiexample.data.remote.Terreno
import com.example.apiexample.databinding.ItemTerrenoBinding

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val terreno = listItemTerrenos[position]
        holder.bind(terreno)
    }

    fun setData(terreno: List<TerrenoEntity>) {
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {
            v.imgTerreno.load(terreno.img)
            v.imgTerreno.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                bundle.putString("tipo", terreno.tipo)
                bundle.putInt("precio", terreno.precio)

                Navigation.findNavController(v.root)
                    .navigate(R.id.action_listadoTerrenos_to_detalleFragment, bundle)
            }

        }
    }
}