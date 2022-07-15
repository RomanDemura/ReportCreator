package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class UpdatePlantUseCase(private val repository: BuildingInfoRepository) {
    fun updatePlant(plant: Plant, import: Int, usage: Int){
        repository.updatePlant(plant, import, usage)
    }
}