package tech.demura.reportcreator.domain.building.repository

import androidx.lifecycle.LiveData
import tech.demura.reportcreator.domain.building.entites.Building

interface BuildingRepository {

    fun addBuilding(building: Building)

    fun getBuilding(id: Int): Building

    fun getAllBuildings(): LiveData<List<Building>>
}