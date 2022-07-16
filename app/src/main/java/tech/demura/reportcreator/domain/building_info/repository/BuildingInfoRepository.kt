package tech.demura.reportcreator.domain.building_info.repository

import tech.demura.reportcreator.domain.Dirt
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.report.entites.Report

interface BuildingInfoRepository {

    fun createBuildingInfo(): BuildingInfo

    fun addPlant(plant: Plant)

    fun updatePlant(plant: Plant, import: Int, usage: Int)

    fun getPlantsList(): List<Plant>

    fun addMachine(machine: Machine)

    fun getMachineList(): List<Machine>

    fun updateDirtInfo(import: Int, export: Int, usage: Int)

    fun addReport(report: Report)

    fun getAllReports(): List<Report>
}