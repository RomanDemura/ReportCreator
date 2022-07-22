package tech.demura.reportcreator.domain.plant.use_case

import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

class GetPlantUseCase(private val repository: PlantRepository) {

    fun getPlant(id: Int): Plant {
        return repository.getPlant(id)
    }
}