package tech.demura.reportcreator.presentation.plant_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.demura.reportcreator.R

class PlantListViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val tvPlantName = view.findViewById<TextView>(R.id.tv_plant_name)
    val tvPlantCount = view.findViewById<TextView>(R.id.tv_plant_count)
}