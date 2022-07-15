package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class GetPlantListUseCase(private val repository: BuildingInfoRepository) {
    fun getPlantsList(): List<Plant>{
        return repository.getPlantsList()
    }
}