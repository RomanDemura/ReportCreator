package tech.demura.reportcreator.presentation.buildings_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.ItemBuildingBinding
import tech.demura.reportcreator.domain.building.entites.Building

class BuildingListAdapter : ListAdapter<Building, BuildingListViewHolder>(BuildingItemDiffCallback()) {

//    var buildingList = listOf<Building>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    var onClickListener : ((Building) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingListViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_building,
            parent,
            false
        )
        return BuildingListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuildingListViewHolder, position: Int) {
        val building = getItem(position)
        if (holder.binding is ItemBuildingBinding)
            holder.binding.building = building
        holder.binding.root.setOnClickListener {
            onClickListener?.invoke(building)
        }
    }
}