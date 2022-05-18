package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

class EditActionUseCase(private val repository: ActionRepository) {
    fun editAction(action: Action){
        repository.editAction(action)
    }
}