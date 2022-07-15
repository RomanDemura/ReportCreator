package tech.demura.reportcreator.data

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo

object BuildingRepositoryImpl: BuildingRepository {
    override fun createBuilding(
        name: String,
        nameOfResponsiblePerson: String,
        address: String
    ) {
        TODO("Not yet implemented")
    }

    override fun createBuildingWithInfo(
        name: String,
        nameOfResponsiblePerson: String,
        address: String,
        buildingInfo: BuildingInfo
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllBuildings(): List<Building> {
        TODO("Not yet implemented")
    }

    override fun getBuilding(id: Int): Building {
        TODO("Not yet implemented")
    }
}