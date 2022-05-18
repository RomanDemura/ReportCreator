package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

class DeleteActionUseCase(private val repository: ActionRepository) {
    fun deleteAction(action: Action){
        repository.deleteAction(action)
    }
}