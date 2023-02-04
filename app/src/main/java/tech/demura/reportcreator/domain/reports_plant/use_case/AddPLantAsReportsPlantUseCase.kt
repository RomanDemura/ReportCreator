package tech.demura.reportcreator.domain.reports_plant.use_case

import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class AddPLantAsReportsPlantUseCase(private val repository: ReportsPlantRepository) {
    fun addPlantAsReportsPlant(plant: Plant, reportId: Int){
        repository.addPlantAsReportsPlant(plant, reportId)
    }
}