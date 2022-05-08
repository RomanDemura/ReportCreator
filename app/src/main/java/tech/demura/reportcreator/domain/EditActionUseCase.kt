package tech.demura.reportcreator.domain

class EditActionUseCase(private val repository: ReportRepository) {
    fun editAction(action: Action){
        repository.editAction(action)
    }
}