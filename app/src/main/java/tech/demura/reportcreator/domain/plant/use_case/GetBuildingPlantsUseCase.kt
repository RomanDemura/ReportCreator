package tech.demura.reportcreator.domain.plant.use_case

import androidx.lifecycle.LiveData
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

class GetBuildingPlantsUseCase(private val repository: PlantRepository) {

    fun getBuildingPlants(buildingId: Int): LiveData<List<Plant>> {
        return repository.getBuildingPlants(buildingId)
    }
}