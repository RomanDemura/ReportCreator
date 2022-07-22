package tech.demura.reportcreator.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository
import tech.demura.reportcreator.domain.report.entites.Report
import java.util.*

object BuildingRepositoryImpl: BuildingRepository {

    private val buildingInfoRep = BuildingInfoRepositoryImpl()
    private var index = 0

    private var buildingsLD = MutableLiveData<List<Building>>()
    private var buildingsList = mutableListOf<Building>()
    private var autoIncrement = 0

    init {
        createBuilding("Prit", "Roma", "Inst4k2")
        getBuilding(0)
        addPlant(Plant("Polka"))
        addMachine(Machine("Traktor"))
        updateDirtInfo(200,0,20)
        val pllist = mutableListOf<Plant>(Plant("Polka", 30,15))
        val rep = Report(Date(32523523),2,5,1,8,0,0,50, pllist.toList(), listOf(), listOf())
        addReport(rep)
        val repimpl = ReportRepositoryImpl()
        Log.d("Test123",repimpl.getReport(building = buildingsList[index], buildingsList[index].reports.first()))


    }


    override fun createBuilding(
        name: String,
        nameOfResponsiblePerson: String,
        address: String
    ) {
        val building = Building(name, nameOfResponsiblePerson, address, id = autoIncrement++)
        buildingsList.add(building)
    }

    override fun getAllBuildings(): List<Building> {
        return buildingsList.toList()
    }

    override fun getBuilding(id: Int): Building {

        val building = buildingsList.find { it.id == id } ?: throw RuntimeException("Building id is not found!")
        this.index = buildingsList.indexOf(building)
        return buildingsList[index]
    }

    override fun addPlant(plant: Plant) {
        buildingsList[index].plantsList.add(plant)
    }

    override fun updatePlant(plant: Plant, import: Int, usage: Int) {
        val plantIndex = buildingsList[index].plantsList.indexOf(plant)
        buildingsList[index].plantsList[plantIndex].importedPlants += import
        buildingsList[index].plantsList[plantIndex].usagePlants += usage
    }

    override fun getPlantsList(): List<Plant> {
        return buildingsList[index].plantsList.toList()
    }

    override fun addMachine(machine: Machine) {
        buildingsList[index].machineList.add(machine)
    }

    override fun getMachineList(): List<Machine> {
        return buildingsList[index].machineList.toList()
    }

    override fun updateDirtInfo(import: Int, export: Int, usage: Int) {
        buildingsList[index].dirt.importedDirt += import
        buildingsList[index].dirt.exportedDirt += export
        buildingsList[index].dirt.usageDirt += usage
    }

    override fun addReport(report: Report) {
        buildingsList[index].reports.add(report)
    }

    override fun getAllReports(): List<Report> {
        return buildingsList[index].reports.toList()
    }
}