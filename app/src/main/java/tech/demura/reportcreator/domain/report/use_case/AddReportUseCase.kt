package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class AddReportUseCase(private val repository: ReportRepository) {

    fun addReport(report: Report){
        repository.addReport(report)
    }
}