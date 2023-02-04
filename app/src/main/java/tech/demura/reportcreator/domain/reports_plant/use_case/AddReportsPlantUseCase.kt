package tech.demura.reportcreator.domain.reports_plant.use_case

import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class AddReportsPlantUseCase(private val repository: ReportsPlantRepository) {
    fun addReportsPlant(reportsPLant: ReportsPlant){
        repository.addReportsPlant(reportsPLant)
    }
}