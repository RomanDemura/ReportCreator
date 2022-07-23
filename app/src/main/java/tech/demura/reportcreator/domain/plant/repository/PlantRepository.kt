package tech.demura.reportcreator.domain.plant.repository

import tech.demura.reportcreator.domain.plant.entites.Plant

interface PlantRepository {

    fun addPlant(plant: Plant)

    fun getPlant(id: Int): Plant

    fun deletePlant(plant: Plant)

    fun updatePlant(plant: Plant)

    fun getBuildingPlants(buildingId: Int): List<Plant>
}