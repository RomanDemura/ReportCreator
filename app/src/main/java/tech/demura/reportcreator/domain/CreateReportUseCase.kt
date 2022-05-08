package tech.demura.reportcreator.domain

class CreateReportUseCase(private val repository: ReportRepository) {
    fun createReport(date: String, builing: String, regularWorker: Int, notRegularWorkers: Int, actions: List<Action>): Report{
        return repository.createReport(date,builing,regularWorker,notRegularWorkers,actions)
    }
}