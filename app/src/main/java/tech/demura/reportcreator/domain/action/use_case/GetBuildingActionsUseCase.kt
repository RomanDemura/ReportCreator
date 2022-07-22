package tech.demura.reportcreator.domain.action.use_case

import tech.demura.reportcreator.domain.action.repository.ActionRepository

class GetBuildingActionsUseCase (private val repository: ActionRepository) {

    fun getBuildingAction(buildingId: Int){
        repository.getBuildingActions(buildingId)
    }
}