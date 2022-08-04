package tech.demura.reportcreator.domain.building.use_case

import androidx.lifecycle.LiveData
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

class GetAllBuildingsUseCase(private val repository: BuildingRepository) {
    fun getAllBuildings(): LiveData<List<Building>>{
        return repository.getAllBuildings()
    }
}