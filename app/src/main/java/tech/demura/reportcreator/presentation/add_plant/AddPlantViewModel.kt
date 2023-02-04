package tech.demura.reportcreator.presentation.add_plant

import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.PlantRepositoryImpl
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.use_case.AddPlantUseCase

class AddPlantViewModel : ViewModel() {

    private val plantRepository = PlantRepositoryImpl
    private val addPlantUseCase = AddPlantUseCase(plantRepository)

    fun addPlant(buildingId: Int, plantName: String, importedPlants: Int, usagePlants: Int) {
        val plant = Plant(
            buildingId = buildingId,
            name = plantName,
            importedPlants = importedPlants,
            usagePlants = usagePlants,
            reportId = -1
        )
        addPlantUseCase.addPlant(plant)
    }
}