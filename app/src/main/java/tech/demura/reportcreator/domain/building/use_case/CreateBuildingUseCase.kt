package tech.demura.reportcreator.domain.building.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

class CreateBuildingUseCase(private val repository: BuildingRepository) {
    fun createBuilding(name: String, nameOfResponsiblePerson: String, address: String) {
        repository.createBuilding(name, nameOfResponsiblePerson, address)
    }
}