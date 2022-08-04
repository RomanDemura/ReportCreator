package tech.demura.reportcreator.presentation.plant_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.PlantRepositoryImpl
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.use_case.GetBuildingPlantsUseCase

class PlantListViewModel: ViewModel() {

    private val repository = PlantRepositoryImpl

    private val getBuildingPlantsUseCase = GetBuildingPlantsUseCase(repository)

    lateinit var plantsList: LiveData<List<Plant>>

    fun getBuildingPlants(buildingId: Int){
        plantsList = getBuildingPlantsUseCase.getBuildingPlants(buildingId)
    }

}