package tech.demura.reportcreator.domain.reports_plant.use_case

import androidx.lifecycle.LiveData
import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class GetAllReportsPlantsUseCase(private val repository: ReportsPlantRepository) {
    fun getAllReportsPlants(reportId: Int): LiveData<List<ReportsPlant>>{
        return repository.getAllReportsPlants(reportId)
    }
}