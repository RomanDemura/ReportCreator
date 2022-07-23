package tech.demura.reportcreator.domain.building.entites

data class Building (
    var id: Int = UNDEFINED_ID,
    var nameOfBuilding: String,
    var nameOfResponsiblePerson: String,
    var address: String
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}