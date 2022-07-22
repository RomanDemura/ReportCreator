package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

class AddActionUseCase (private val repository: ActionRepository) {

    fun addAction (action: Action){
        repository.addAction(action)
    }
}