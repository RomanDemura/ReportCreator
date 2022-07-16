package tech.demura.reportcreator.data


import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.Dirt
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository
import tech.demura.reportcreator.domain.report.entites.Report
import java.util.*

class BuildingInfoRepositoryImpl : BuildingInfoRepository {

    private var plantList = mutableListOf<Plant>()
    private val machineList = mutableListOf<Machine>()
    private val dirt = Dirt()
    private val reportList = mutableListOf<Report>()

    override fun createBuildingInfo(): BuildingInfo {
        return BuildingInfo(plantList.toList(), machineList.toList(), dirt, reportList.toList())
    }

    override fun addPlant(plant: Plant) {
        plantList.add(plant)
    }

    override fun updatePlant(plant: Plant, import: Int, usage: Int) {
        val plantIndex = plantList.indexOf(plant)
        plantList[plantIndex].importedPlants += import
        plantList[plantIndex].usagePlants += usage
    }

    override fun getPlantsList(): List<Plant> {
        return plantList.toList()
    }

    override fun addMachine(machine: Machine) {
        machineList.add(machine)
    }

    override fun getMachineList(): List<Machine> {
        return machineList.toList()
    }

    override fun updateDirtInfo(import: Int, export: Int, usage: Int) {
        dirt.importedDirt += import
        dirt.exportedDirt += export
        dirt.usageDirt += usage
    }

    override fun addReport(report: Report) {
        reportList.add(report)
    }

    override fun getAllReports(): List<Report> {
        return reportList.toList()
    }
}