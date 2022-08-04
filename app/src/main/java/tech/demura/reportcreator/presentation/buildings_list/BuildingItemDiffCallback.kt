package tech.demura.reportcreator.presentation.buildings_list

import androidx.recyclerview.widget.DiffUtil
import tech.demura.reportcreator.domain.building.entites.Building

class BuildingItemDiffCallback: DiffUtil.ItemCallback<Building>() {
    override fun areItemsTheSame(oldItem: Building, newItem: Building): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Building, newItem: Building): Boolean {
        return oldItem == newItem
    }
}