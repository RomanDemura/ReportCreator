package tech.demura.reportcreator.domain.report.use_case

import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class GetBuildingReportsUseCase(private val repository: ReportRepository) {

    fun getBuildingReports(buildingId: Int): List<Report>{
        return repository.getBuildingReports(buildingId)
    }
}