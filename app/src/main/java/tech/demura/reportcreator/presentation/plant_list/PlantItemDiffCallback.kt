package tech.demura.reportcreator.presentation.plant_list

import androidx.recyclerview.widget.DiffUtil
import tech.demura.reportcreator.domain.plant.entites.Plant

class PlantItemDiffCallback: DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem == newItem
    }
}