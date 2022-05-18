package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository


class GetActionUseCase(private val repository: ActionRepository) {
    fun getAction(actionId: Int): Action {
        return repository.getAction(actionId)
    }
}