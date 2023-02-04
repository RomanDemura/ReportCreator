package tech.demura.reportcreator.domain.reports_plant.use_case

import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

class SubmitChangedReportsPlantsUseCase(private val repository: ReportsPlantRepository) {
    fun submitChangedReportsPlants(){
        repository.submitChangedReportsPlants()
    }
}