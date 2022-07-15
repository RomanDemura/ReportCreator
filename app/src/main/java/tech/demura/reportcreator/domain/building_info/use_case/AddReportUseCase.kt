package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository
import tech.demura.reportcreator.domain.report.entites.Report

class AddReportUseCase(private val repository: BuildingInfoRepository) {
    fun addReport(report: Report){
        repository.addReport(report = report)
    }
}