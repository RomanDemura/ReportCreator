package tech.demura.reportcreator.domain.plant.use_case

import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

class UpdatePlantUseCase(private val repository: PlantRepository) {

    fun updatePlant(plant: Plant){
        repository.updatePlant(plant)
    }
}