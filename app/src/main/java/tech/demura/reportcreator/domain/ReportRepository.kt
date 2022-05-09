package tech.demura.reportcreator.domain

interface ReportRepository {

    fun createReport(
        date: String,
        builing: String,
        regularWorker: Int,
        notRegularWorkers: Int,
        actions: List<Action>
    ): Report

    fun getReport(): String

    fun addAction(action: Action)

    fun deleteAction(action: Action)

    fun editAction(action: Action)

    fun getAction(actionId: Int): Action
}