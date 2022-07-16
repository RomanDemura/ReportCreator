package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository
import tech.demura.reportcreator.domain.building_info.use_case.CreateBuildingInfoUseCase

object BuildingRepositoryImpl: BuildingRepository {

    private val buildingInfoRep = BuildingInfoRepositoryImpl()

    private var buildingsLD = MutableLiveData<List<Building>>()
    private var buildingsList = mutableListOf<Building>()
    private var autoIncrement = 0

    init {
        createBuilding("Prit", "Roma", "Inst4k2")
        getBuilding(0).buildingInfo.
    }


    override fun createBuilding(
        name: String,
        nameOfResponsiblePerson: String,
        address: String
    ) {
        val info = buildingInfoRep.createBuildingInfo()
        val building = Building(name, nameOfResponsiblePerson, address, info, id = autoIncrement++)
        buildingsList.add(building)
    }

    override fun getAllBuildings(): List<Building> {
        return buildingsList.toList()
    }

    override fun getBuilding(id: Int): Building {
        return buildingsList.find { it.id == id } ?: throw RuntimeException("Building id is not found!")
    }
}