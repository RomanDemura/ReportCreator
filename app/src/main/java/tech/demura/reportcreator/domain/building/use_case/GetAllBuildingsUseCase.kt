package tech.demura.reportcreator.domain.building.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

class GetAllBuildingsUseCase(private val repository: BuildingRepository) {
    fun getAllBuildings(): List<Building>{
        return repository.getAllBuildings()
    }
}