package tech.demura.reportcreator.domain.building.repository

import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo

interface BuildingRepository {

     fun createBuilding(name: String, nameOfResponsiblePerson: String, address: String): Building

     fun createBuildingWithInfo(
         name: String,
         nameOfResponsiblePerson: String,
         address: String,
         buildingInfo: BuildingInfo
     ): Building

     fun getAllBuildings(): List<Building>

     fun getBuilding(id: Int): Building
}