package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository
import tech.demura.reportcreator.domain.report.entites.Report

class GetAllReportsUseCase(private val repository: BuildingInfoRepository) {
    fun getAllReports(): List<Report>{
        return repository.getAllReports()
    }
}