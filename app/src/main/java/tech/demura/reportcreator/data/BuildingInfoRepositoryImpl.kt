package tech.demura.reportcreator.data


import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository
import tech.demura.reportcreator.domain.report.entites.Report

object BuildingInfoRepositoryImpl: BuildingInfoRepository {

    override fun addPlant(plant: Plant) {
        TODO("Not yet implemented")
    }

    override fun updatePlant(plant: Plant, import: Int, usage: Int) {
        TODO("Not yet implemented")
    }

    override fun getPlantsList(): List<Plant> {
        TODO("Not yet implemented")
    }

    override fun addMachine(machine: Machine) {
        TODO("Not yet implemented")
    }

    override fun getMachineList(): List<Machine> {
        TODO("Not yet implemented")
    }

    override fun updateDirtInfo(import: Int, export: Int, usage: Int) {
        TODO("Not yet implemented")
    }

    override fun addReport(report: Report) {
        TODO("Not yet implemented")
    }

    override fun getAllReports(): List<Report> {
        TODO("Not yet implemented")
    }
}