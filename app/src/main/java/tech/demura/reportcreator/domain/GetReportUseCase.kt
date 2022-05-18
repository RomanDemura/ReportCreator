package tech.demura.reportcreator.domain

class GetReportUseCase(private val repository: ReportRepository) {
    fun getReport(): String{
        return repository.getReport()
    }
}