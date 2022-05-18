package tech.demura.reportcreator.domain

data class Action(
    var text: String,
    var value: Double,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}