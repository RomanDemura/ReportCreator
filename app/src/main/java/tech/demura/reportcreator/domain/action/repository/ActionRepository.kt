package tech.demura.reportcreator.domain.action.repository

import tech.demura.reportcreator.domain.action.entites.Action

interface ActionRepository {

    fun addAction(action: Action)

    fun getAction(id: Int): Action

    fun getBuildingActions(buildingId: Int): List<Action>
}