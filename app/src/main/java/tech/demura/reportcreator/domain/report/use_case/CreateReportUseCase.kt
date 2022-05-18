package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class CreateReportUseCase(private val repository: ReportRepository) {
    fun createReport(date: String, builing: String, regularWorker: Int, notRegularWorkers: Int, actions: List<Action>): Report {
        return repository.createReport(date,builing,regularWorker,notRegularWorkers,actions)
    }
}