package tech.demura.reportcreator.domain.action.entites

data class Action (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    var action: String = "Default Action name",
    var value: Int = 0,
    var unitsOfMeasure: String = "uom"
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}