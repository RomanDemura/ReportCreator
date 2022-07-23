package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

object ActionRepositoryImpl: ActionRepository {

    private var actionsLD = MutableLiveData<List<Action>>()
    private var actionsList = sortedSetOf<Action>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    init {
        for(i in 1 .. 5){
            val action = Action(buildingId = 0, action = "Действие $i", value = i)
            addAction(action)
        }
    }


    override fun addAction(action: Action) {
        if (action.id == Action.UNDEFINED_ID) {
            action.id = autoIncrement++
        }
        actionsList.add(action)
        updateLD()
    }

//    override fun deleteAction(action: BuildingInfo) {
//        actionsList.remove(action)
//        updateLD()
//    }


    override fun getAction(actionId: Int): Action {
        return actionsList.find {
            it.id == actionId
        } ?: throw RuntimeException("Action with $actionId actionId not found")
    }

    override fun getBuildingActions(buildingId: Int): List<Action> {
        return actionsList.filter { it.buildingId == buildingId }
    }

    private fun updateLD() {
        actionsLD.value = actionsList.toList()
    }
}