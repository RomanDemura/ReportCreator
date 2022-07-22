package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class GetReportInfoUseCase(private val repository: ReportRepository) {

    fun getReportInfo(report: Report): String{
        return repository.getReportInfo(report)
    }
}