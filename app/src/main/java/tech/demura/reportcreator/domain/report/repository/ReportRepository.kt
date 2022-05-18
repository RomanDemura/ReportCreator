package tech.demura.reportcreator.domain.report.repository

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.report.entites.Report

interface ReportRepository {

    fun createReport(
        date: String,
        builing: String,
        regularWorker: Int,
        notRegularWorkers: Int,
        actions: List<Action>
    ): Report

    fun getReport(): String
}