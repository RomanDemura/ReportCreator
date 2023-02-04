package tech.demura.reportcreator.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.repository.ReportRepository
import java.text.SimpleDateFormat
import java.util.*

object ReportRepositoryImpl : ReportRepository {

    val reportLD = MutableLiveData<List<Report>>()
    val reportList = sortedSetOf<Report>({o1, o2 -> o1.id.compareTo(o2.id)})
    var autoIncrement = 0

    init {
        val timeInMillis = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("dd.MM.yy", Locale.getDefault())
        val dateText = dateFormat.format(timeInMillis)

        val report1 = Report(Report.UNDEFINED_ID,0, timeInMillis,1,1,1,6,120,0,50)
        val report2 = Report(Report.UNDEFINED_ID,0, timeInMillis,2,2,2,7,120,0,50)
        val report3 = Report(Report.UNDEFINED_ID,0, timeInMillis,3,3,3,8,120,0,50)

        addReport(report1)
        addReport(report2)
        addReport(report3)
    }

    override fun addReport(report: Report): Report {
        if (report.id == Report.UNDEFINED_ID){
            report.id = autoIncrement++
        }
        reportList.add(report)
        updateLD()
        return report
    }

    override fun updateReport(report: Report) {
        val oldReport = reportList.find { it.id == report.id }
        if (oldReport != null){
            reportList.remove(oldReport)
        }
        addReport(report)
    }

    override fun getReport(id: Int): Report {
        return reportList.find { it.id == id } ?: throw RuntimeException("Invalid Report ID: $id")
    }

    override fun getReportInfo(report: Report): String {
        TODO("Not yet implemented")
    }

    override fun getBuildingReports(buildingId: Int): LiveData<List<Report>>{
        reportLD.value = reportList.filter { it.buildingId == buildingId }
        return reportLD
    }

    private fun updateLD(){
        reportLD.value = reportList.toList()
    }
}