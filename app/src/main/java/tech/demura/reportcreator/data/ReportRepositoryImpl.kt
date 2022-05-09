package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.Action
import tech.demura.reportcreator.domain.Report
import tech.demura.reportcreator.domain.ReportRepository

object ReportRepositoryImpl : ReportRepository {

    private lateinit var report: Report
    private var actionsLD = MutableLiveData<List<Action>>()
    private var actionsList = sortedSetOf<Action>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    init {
        for (i in 1..10) {
            addAction(Action("Action: $i", i.toDouble()))
        }
        report = Report(
            "09.05.2022",
            "ЖК Притяжение",
            4,
            6,
            actionsList.toList()
        )
    }

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

    override fun getAction(actionId: Int): Action {
        return actionsList.find {
            it.id == actionId
        } ?: throw RuntimeException("Action with $actionId actionId not found")
    }

    override fun addAction(action: Action) {
        if (action.id == Action.UNDEFINED_ID) {
            action.id = autoIncrement++
        }
        actionsList.add(action)
        updateLD()

    }

    override fun deleteAction(action: Action) {
        actionsList.remove(action)
        updateLD()
    }

    override fun editAction(action: Action) {
        val oldAction = getAction(action.id)
        deleteAction(oldAction)
        addAction(action)
        updateLD()
    }

    private fun updateLD() {
        actionsLD.value = actionsList.toList()
    }
}