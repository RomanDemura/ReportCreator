package tech.demura.reportcreator.domain.building.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

class AddBuildingUseCase(private val repository: BuildingRepository) {

    fun addBuilding(building: Building){
        repository.addBuilding(building)
    }
}