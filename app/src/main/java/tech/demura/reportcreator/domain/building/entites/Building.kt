package tech.demura.reportcreator.domain.building.entites

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo

data class Building (
    val name: String,
    val nameOfResponsiblePerson: String,
    val address: String,
    val buildingInfo: BuildingInfo,

    val id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}