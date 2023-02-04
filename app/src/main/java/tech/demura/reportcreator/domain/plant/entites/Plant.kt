package tech.demura.reportcreator.domain.plant.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    var reportId: Int,
    var name: String,
    var importedPlants: Int,
    var usagePlants: Int
): Parcelable {
    companion object{
        const val UNDEFINED_ID = -1
    }
}