package tech.demura.reportcreator.domain.building.repository

import tech.demura.reportcreator.domain.building.entites.Building

interface BuildingRepository {

    fun addBuilding(building: Building)

    fun getBuilding(id: Int): Building

    fun getAllBuildings(): List<Building>
}