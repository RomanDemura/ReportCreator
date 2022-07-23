package tech.demura.reportcreator.domain.machine.entites

data class Machine (
    var id: Int = UNDEFINED_ID,
    var buildingId: Int,
    var name: String = "Default Machine name"
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}