package tech.demura.reportcreator.domain.building.entites

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Building (
    var id: Int = UNDEFINED_ID,
    var nameOfBuilding: String,
    var nameOfResponsiblePerson: String,
    var address: String
) : Parcelable {
    companion object{
        const val UNDEFINED_ID = -1
    }
}