package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

class CreateActionUseCase (private val repository: ActionRepository) {
    fun createAction(text: String, value: Int): Action {
        return repository.createAction(text, value)
    }
}