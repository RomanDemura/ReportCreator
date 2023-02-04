package tech.demura.reportcreator.presentation.plant_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.ItemPlantBinding
import tech.demura.reportcreator.domain.plant.entites.Plant

class PlantListAdapter : ListAdapter<Plant, PlantListViewHolder>(PlantItemDiffCallback()) {

//    var plantsList = listOf<Plant>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_plant,
            parent,
            false
        )
        return PlantListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantListViewHolder, position: Int) {
        val plant = getItem(position)
        if (holder.binding is ItemPlantBinding){
            holder.binding.plant = plant
        }
    }

}