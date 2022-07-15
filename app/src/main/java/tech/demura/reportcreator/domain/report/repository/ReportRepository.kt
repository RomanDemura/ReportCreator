package tech.demura.reportcreator.domain.report.repository

import tech.demura.reportcreator.domain.Action
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.report.entites.Report
import java.util.*

interface ReportRepository {

    fun createReport(
        building: Building,
        date: Date,
        countOfRegularWorkers: Int,
        countOfNotRegularWorkers: Int,
        countOfSocialWorkers: Int,
        workShift: Int,
        dirtImport: Int,
        dirtExport: Int,
        dirtUsage: Int,
        plantsList: List<Plant>,
        machines: List<Machine>,
        anotherActions: List<Action>,
    ): Report

    fun getReport(id: Int): String
}