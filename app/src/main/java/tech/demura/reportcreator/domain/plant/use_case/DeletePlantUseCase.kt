package tech.demura.reportcreator.domain.plant.use_case

import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

class DeletePlantUseCase(private val repository: PlantRepository) {

    fun deletePlant(plant: Plant){
        repository.deletePlant(plant)
    }
}