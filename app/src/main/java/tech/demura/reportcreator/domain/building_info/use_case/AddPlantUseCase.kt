package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class AddPlantUseCase(private val repository: BuildingInfoRepository) {
    fun addPlant(plant: Plant){
        repository.addPlant(plant = plant)
    }
}