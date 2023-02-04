package tech.demura.reportcreator.domain.reports_plant.entites

data class ReportsPlant (
    var id: Int = UNDEFINED_ID,
    var reportId: Int,
    var name: String,
    var importedPlants: Int = 0,
    var usagePlants: Int = 0
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}