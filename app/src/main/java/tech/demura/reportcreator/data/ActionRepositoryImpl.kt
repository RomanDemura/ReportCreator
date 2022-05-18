package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.action.repository.ActionRepository

object ActionRepositoryImpl: ActionRepository {

    private var actionsLD = MutableLiveData<List<Action>>()
    private var actionsList = sortedSetOf<Action>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

//    init {
//        for(i in 1 .. 5){
//            val action = createAction("Действие $i", i)
//            addAction(action)
//        }
//    }

    override fun createAction(text: String, value: Int): Action {
        return Action(text, value)
    }

    override fun addAction(action: Action) {
        if (action.id == Action.UNDEFINED_ID) {
            action.id = autoIncrement++
        }
        actionsList.add(action)
        updateLD()
    }

    override fun deleteAction(action: Action) {
        actionsList.remove(action)
        updateLD()
    }

    override fun editAction(action: Action) {
        val oldAction = getAction(action.id)
        deleteAction(oldAction)
        addAction(action)
        updateLD()
    }

    override fun getAction(actionId: Int): Action {
        return actionsList.find {
            it.id == actionId
        } ?: throw RuntimeException("Action with $actionId actionId not found")
    }

    override fun getActionList(): List<Action> {
        return actionsLD.value ?: throw RuntimeException("ActionLD == null")
    }

    private fun updateLD() {
        actionsLD.value = actionsList.toList()
    }
}