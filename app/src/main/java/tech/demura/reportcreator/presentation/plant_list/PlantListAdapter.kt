package tech.demura.reportcreator.presentation.plant_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.demura.reportcreator.R
import tech.demura.reportcreator.domain.plant.entites.Plant

class PlantListAdapter : RecyclerView.Adapter<PlantListViewHolder>() {

    var plantsList = listOf<Plant>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_plant,parent,false)
        return PlantListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantListViewHolder, position: Int) {
        val plant = plantsList[position]
        holder.tvPlantName.text = plant.name
        holder.tvPlantCount.text = "${plant.usagePlants} / ${plant.importedPlants}"
    }

    override fun getItemCount(): Int {
        return plantsList.size
    }
}