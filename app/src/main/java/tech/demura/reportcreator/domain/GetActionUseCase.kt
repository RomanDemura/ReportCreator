package tech.demura.reportcreator.domain

class GetActionUseCase(private val repository: ReportRepository) {
    fun getAction(actionId: Int): Action{
        return repository.getAction(actionId)
    }
}