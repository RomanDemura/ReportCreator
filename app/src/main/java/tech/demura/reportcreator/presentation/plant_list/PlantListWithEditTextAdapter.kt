package tech.demura.reportcreator.presentation.plant_list

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.demura.reportcreator.databinding.ItemPlantWithEditTextBinding
import tech.demura.reportcreator.domain.plant.entites.Plant

class PlantListWithEditTextAdapter(
    private val listener: PlantsListListener
) : RecyclerView.Adapter<PlantListWithEditTextAdapter.PlantListWithEditTextViewHolder>() {

    fun interface PlantsListListener {
        fun onPlantCountChanged(plantWithNewCount: Plant)
    }

    private var items: List<Plant> = emptyList()

    fun setItems(newItems: List<Plant>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlantListWithEditTextViewHolder {
        return PlantListWithEditTextViewHolder(
            binding = ItemPlantWithEditTextBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: PlantListWithEditTextViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PlantListWithEditTextViewHolder(private val binding: ItemPlantWithEditTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Plant) {
            with(binding) {
                tvPlantName.text = item.name
                etUsagePlants.setText(item.usagePlants.toString())
                binding.etUsagePlants.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) =
                        Unit

                    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        text?.let {
                            if (it.isEmpty()){
                                listener.onPlantCountChanged(
                                    plantWithNewCount = item.copy(usagePlants = 0)
                                )
                            } else {
                                listener.onPlantCountChanged(
                                    plantWithNewCount = item.copy(usagePlants = it.toString().toInt())
                                )
                            }
                        }
                    }

                    override fun afterTextChanged(p0: Editable?) = Unit

                })
            }
        }
    }
}