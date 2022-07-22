package tech.demura.reportcreator.domain.dirt.entites

data class Dirt (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    var importedDirt: Int = 0,
    var exportedDirt: Int = 0,
    var usageDirt: Int = 0
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}