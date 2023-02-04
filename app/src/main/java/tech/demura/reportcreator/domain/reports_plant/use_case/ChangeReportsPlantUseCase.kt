package tech.demura.reportcreator.domain.reports_plant.use_case

import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class ChangeReportsPlantUseCase(private val repositrory: ReportsPlantRepository) {
    fun changeReportsPlant(newPlant: ReportsPlant){
        repositrory.changeReportsPlant(newPlant)
    }
}