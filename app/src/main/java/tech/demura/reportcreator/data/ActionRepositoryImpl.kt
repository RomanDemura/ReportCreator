package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

object ActionRepositoryImpl: BuildingInfoRepository {

    private var actionsLD = MutableLiveData<List<BuildingInfo>>()
    private var actionsList = sortedSetOf<BuildingInfo>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

//    init {
//        for(i in 1 .. 5){
//            val action = createAction("Действие $i", i)
//            addAction(action)
//        }
//    }

    override fun createAction(text: String, value: Int): BuildingInfo {
        return BuildingInfo(text, value)
    }

    override fun addAction(action: BuildingInfo) {
        if (action.id == BuildingInfo.UNDEFINED_ID) {
            action.id = autoIncrement++
        }
        actionsList.add(action)
        updateLD()
    }

    override fun deleteAction(action: BuildingInfo) {
        actionsList.remove(action)
        updateLD()
    }

    override fun editAction(action: BuildingInfo) {
        val oldAction = getAction(action.id)
        deleteAction(oldAction)
        addAction(action)
        updateLD()
    }

    override fun getAction(actionId: Int): BuildingInfo {
        return actionsList.find {
            it.id == actionId
        } ?: throw RuntimeException("Action with $actionId actionId not found")
    }

    override fun getActionList(): List<BuildingInfo> {
        return actionsLD.value ?: throw RuntimeException("ActionLD == null")
    }

    private fun updateLD() {
        actionsLD.value = actionsList.toList()
    }
}