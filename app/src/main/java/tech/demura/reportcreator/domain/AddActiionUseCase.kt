package tech.demura.reportcreator.domain

class AddActiionUseCase(private val repository: ReportRepository) {
    fun addAction(action: Action){
        repository.addAction(action)
    }
}
