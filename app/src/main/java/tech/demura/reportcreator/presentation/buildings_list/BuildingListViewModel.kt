package tech.demura.reportcreator.presentation.buildings_list

import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.BuildingRepositoryImpl
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.use_case.AddBuildingUseCase
import tech.demura.reportcreator.domain.building.use_case.GetAllBuildingsUseCase
import tech.demura.reportcreator.domain.building.use_case.GetBuildingUseCase

class BuildingListViewModel: ViewModel() {

    private val buildingRepository = BuildingRepositoryImpl

    private val addBuildingUseCase = AddBuildingUseCase(buildingRepository)
    private val getBuildingUseCase = GetBuildingUseCase(buildingRepository)
    private val getAllBuildingsUseCase = GetAllBuildingsUseCase(buildingRepository)

    val buildingList = getAllBuildingsUseCase.getAllBuildings()

    fun getBuilding(id: Int): Building{
        return getBuildingUseCase.getBuilding(id)
    }
}