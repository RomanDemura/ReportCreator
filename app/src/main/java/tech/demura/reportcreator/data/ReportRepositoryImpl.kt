package tech.demura.reportcreator.data

import tech.demura.reportcreator.domain.Action
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository
import java.util.*

object ReportRepositoryImpl : ReportRepository {

    private lateinit var report: Report
//    private val actions1 = ActionRepositoryImpl
//
//    init {
//
//        report = Report(
//            "09.05.2022",
//            "ЖК Притяжение",
//            4,
//            6,
//            actions1.getActionList()
//        )
//    }


//    override fun getReport(): String {
////        report = report.copy(actions = actionsList.toList())
//        val reportString = StringBuilder()
//        reportString.append("${report.date}: ${report.building}.\n")
//        if (report.countOfRegularWorkers > 0) {
//            reportString.append("Штат: ${report.countOfRegularWorkers}. ")
//        }
//        if (report.countOfNotRegularWorkers > 0) {
//            reportString.append("Рабочий класс: ${report.countOfNotRegularWorkers}.")
//        }
//        for (action in report.actions) {
//            reportString.append("\n${action.text}")
//            if (action.value > 0)
//                reportString.append(": ${action.value}")
//        }
//        return reportString.toString()
//    }

    override fun createReport(
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
        anotherActions: List<Action>
    ): Report {
        return Report(
            building,
            date,
            countOfRegularWorkers,
            countOfNotRegularWorkers,
            countOfSocialWorkers,
            workShift,
            dirtImport,
            dirtExport,
            dirtUsage,
            plantsList,
            machines,
            anotherActions)
    }

    override fun getReport(id: Int): String {
        TODO("Not yet implemented")
    }


}