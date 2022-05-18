package tech.demura.reportcreator.domain.action.repository

import tech.demura.reportcreator.domain.action.entites.Action

interface ActionRepository {

    fun createAction(text: String, value: Int): Action

    fun addAction(action: Action)

    fun deleteAction(action: Action)

    fun editAction(action: Action)

    fun getAction(actionId: Int): Action

    fun getActionList(): List<Action>
}