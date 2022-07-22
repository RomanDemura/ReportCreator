package tech.demura.reportcreator.domain.action.entites

data class Action (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    val action: String = "Default Action name",
    val value: Int = 0,
    val unitsOfMeasure: String = "uom"
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}