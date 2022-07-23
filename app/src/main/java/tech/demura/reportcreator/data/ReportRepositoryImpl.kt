package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository

class ReportRepositoryImpl : ReportRepository {

    val reportLD = MutableLiveData<List<Report>>()
    val reportList = sortedSetOf<Report>({o1, o2 -> o1.id.compareTo(o2.id)})
    var autoIncrement = 0

    override fun addReport(report: Report) {
        if (report.id == Report.UNDEFINED_ID){
            report.id = autoIncrement++
        }
        reportList.add(report)
        updateLD()
    }

    override fun getReport(id: Int): Report {
        return reportList.find { it.id == id } ?: throw RuntimeException("Invalid Report ID: $id")
    }

    override fun getReportInfo(report: Report): String {
        TODO("Not yet implemented")
    }

    override fun getBuildingReports(buildingId: Int): List<Report> {
        return reportList.filter { it.buildingId == buildingId }
    }

    private fun updateLD(){
        reportLD.value = reportList.toList()
    }
}