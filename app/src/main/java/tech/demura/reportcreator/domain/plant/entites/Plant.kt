package tech.demura.reportcreator.domain.plant.entites

data class Plant (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    val name: String,
    var importedPlants: Int,
    var usagePlants: Int
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}