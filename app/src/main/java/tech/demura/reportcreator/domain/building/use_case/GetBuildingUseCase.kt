package tech.demura.reportcreator.domain.building.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

class GetBuildingUseCase(private val repository: BuildingRepository) {
    fun getBuilding(id: Int): Building{
        return repository.getBuilding(id)
    }
}