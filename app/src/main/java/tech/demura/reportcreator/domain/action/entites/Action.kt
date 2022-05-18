package tech.demura.reportcreator.domain.action.entites

data class Action(
    var text: String,
    var value: Int,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}