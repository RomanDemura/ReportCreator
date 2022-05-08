package tech.demura.reportcreator.domain

class DeleteActionUseCase(private val repository: ReportRepository) {
    fun deleteAction(action: Action){
        repository.deleteAction(action)
    }
}