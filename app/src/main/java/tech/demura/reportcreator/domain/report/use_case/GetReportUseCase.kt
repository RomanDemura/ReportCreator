package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class GetReportUseCase(private val repository: ReportRepository) {
    fun getReport(building: Building, report: Report): String{
        return repository.getReport(building, report)
    }
}