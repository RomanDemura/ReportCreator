package tech.demura.reportcreator.data

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

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

    override fun createReport(
        date: String,
        builing: String,
        regularWorker: Int,
        notRegularWorkers: Int,
        actions: List<Action>
    ): Report {
        return Report(date, builing, regularWorker, notRegularWorkers, actions)
    }

    override fun getReport(): String {
//        report = report.copy(actions = actionsList.toList())
        val reportString = StringBuilder()
        reportString.append("${report.date}: ${report.building}.\n")
        if (report.countOfRegularWorkers > 0) {
            reportString.append("Штат: ${report.countOfRegularWorkers}. ")
        }
        if (report.countOfNotRegularWorkers > 0) {
            reportString.append("Рабочий класс: ${report.countOfNotRegularWorkers}.")
        }
        for (action in report.actions) {
            reportString.append("\n${action.text}")
            if (action.value > 0)
                reportString.append(": ${action.value}")
        }
        return reportString.toString()
    }









}