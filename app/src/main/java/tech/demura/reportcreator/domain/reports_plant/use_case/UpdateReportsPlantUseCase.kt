package tech.demura.reportcreator.domain.reports_plant.use_case

import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class UpdateReportsPlantUseCase(private val repository: ReportsPlantRepository) {
    fun updateReportsPlant(reportsPlant: ReportsPlant){
        repository.updateReportsPlant(reportsPlant)
    }
}