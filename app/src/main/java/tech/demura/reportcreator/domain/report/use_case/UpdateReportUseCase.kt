package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class UpdateReportUseCase(private val repository: ReportRepository) {
    fun updateReport(report: Report){
        repository.updateReport(report)
    }
}