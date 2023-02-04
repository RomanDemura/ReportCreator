package tech.demura.reportcreator.presentation

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import tech.demura.reportcreator.R
import tech.demura.reportcreator.data.BuildingRepositoryImpl
import tech.demura.reportcreator.domain.building.use_case.GetBuildingUseCase
import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.plant.entites.Plant
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("plantCounter")
fun plantCounterBind(textView: TextView, plant: Plant) {
    textView.text = String.format(
        textView.context.getString(R.string.default_plant_count),
        plant.usagePlants,
        plant.importedPlants
    )
}

@BindingAdapter("dirtCounter")
fun dirtCounterBind(textView: TextView, dirt: Dirt) {
    textView.text = String.format(
        textView.context.getString(R.string.default_dirt_count),
        dirt.usageDirt,
        dirt.importedDirt - dirt.exportedDirt
    )
}

@BindingAdapter("reportBuilding")
fun reportBuildingBind(textView: TextView, buildingId: Int) {
    val repository = BuildingRepositoryImpl
    val getBuildingUseCase = GetBuildingUseCase(repository)
    val building = getBuildingUseCase.getBuilding(buildingId)
    textView.text = building.nameOfBuilding
}

@BindingAdapter("reportDate")
fun reportDateBind(textView: TextView, date: Long) {
    val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())

    textView.text = dateFormat.format(date)
}


@BindingAdapter("errorInputNameOfBuilding")
fun ErrorInputNameOfBuildingBind (textInputLayout: TextInputLayout, isError: Boolean){
    val message = if (isError){
        textInputLayout.context.getString(R.string.error_input_name_of_building)
    } else
        null
    textInputLayout.error = message
}

@BindingAdapter("errorInputResponsiblePerson")
fun ErrorInputResponsiblePersonBind (textInputLayout: TextInputLayout, isError: Boolean){
    val message = if (isError){
        textInputLayout.context.getString(R.string.error_input_name_of_responsible_person)
    } else
        null
    textInputLayout.error = message
}

@BindingAdapter("errorInputAddress")
fun ErrorInputAddressBind (textInputLayout: TextInputLayout, isError: Boolean){
    val message = if (isError){
        textInputLayout.context.getString(R.string.error_input_address)
    } else
        null
    textInputLayout.error = message
}