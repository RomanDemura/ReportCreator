package tech.demura.reportcreator.presentation.report_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.ReportRepositoryImpl
import tech.demura.reportcreator.domain.report.entites.Report
import tech.demura.reportcreator.domain.report.use_case.GetBuildingReportsUseCase

class ReportListViewModel: ViewModel() {

    private val repository = ReportRepositoryImpl

    private val getBuildingReportsUseCase = GetBuildingReportsUseCase(repository)

    lateinit var reportList: LiveData<List<Report>>

    fun getBuildingReports(buildingId: Int){
        reportList = getBuildingReportsUseCase.getBuildingReports(buildingId)
    }
}