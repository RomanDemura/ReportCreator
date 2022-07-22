package tech.demura.reportcreator.domain.building.entites

data class Building (
    val id: Int = UNDEFINED_ID,
    val nameOfBuilding: String,
    val nameOfResponsiblePerson: String,
    val address: String
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}