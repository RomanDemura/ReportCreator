package tech.demura.reportcreator.domain.building.use_case

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo

class CreateBuildingWithInfoUseCase(private val repository: BuildingRepository) {
    fun createBuildingWithInfo(
        name: String,
        nameOfResponsiblePerson: String,
        address: String,
        buildingInfo: BuildingInfo
    ) {
        repository.createBuildingWithInfo(
            name,
            nameOfResponsiblePerson,
            address,
            buildingInfo
        )
    }
}