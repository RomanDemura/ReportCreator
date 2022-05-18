package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

class GetActionListUseCase(private val repository: ActionRepository) {
    fun getActionList(): List<Action>{
        return repository.getActionList()
    }
}