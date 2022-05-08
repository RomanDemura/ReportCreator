package tech.demura.reportcreator.domain

class GetReportUseCase(private val repository: ReportRepository) {
    fun getReport(report: Report): String{
        return repository.getReport(report)
    }
}