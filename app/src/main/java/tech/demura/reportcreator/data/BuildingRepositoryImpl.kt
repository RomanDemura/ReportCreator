package tech.demura.reportcreator.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository
import tech.demura.reportcreator.domain.report.entites.Report
import java.util.*

object BuildingRepositoryImpl: BuildingRepository {

    private var buildingsLD = MutableLiveData<List<Building>>()
    private var buildingsList = sortedSetOf<Building>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    init {
        updateLD()
        for (i in 1 .. 25){
            val building = Building(nameOfBuilding = "Build $i", address = "Something", nameOfResponsiblePerson = "Roman")
            addBuilding(building)
        }
    }

    override fun addBuilding(building: Building) {
        if (building.id == Building.UNDEFINED_ID) {
            building.id = autoIncrement++
        }
        buildingsList.add(building)
        updateLD()
    }

    override fun getBuilding(id: Int): Building {
        return buildingsList.find {
            it.id == id
        } ?: throw RuntimeException("Invalid Building ID: $id")
    }

    override fun getAllBuildings(): LiveData<List<Building>> {
        return buildingsLD
    }

    private fun updateLD() {
        buildingsLD.value = buildingsList.toList()
    }
}