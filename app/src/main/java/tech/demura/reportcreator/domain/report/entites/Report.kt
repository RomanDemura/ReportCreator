package tech.demura.reportcreator.domain.report.entites

import tech.demura.reportcreator.domain.action.entites.Action


data class Report(
    val date: String,
    val building: String,
    val countOfRegularWorkers: Int,
    val countOfNotRegularWorkers: Int,
    val actions: List<Action>,
    val id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}