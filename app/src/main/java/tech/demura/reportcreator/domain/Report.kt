package tech.demura.reportcreator.domain


data class Report(
    val date: String,
    val building: String,
    val countOfRegularWorkers: Int,
    val countOfNotRegularWorkers: Int,
    val actions: List<Action>
)