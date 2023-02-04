package tech.demura.reportcreator.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.repository.BuildingRepository

object BuildingRepositoryImpl : BuildingRepository {

    private var buildingsLD = MutableLiveData<List<Building>>()
    private var buildingsList = sortedSetOf<Building>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    init {
        updateLD()
        val building1 = Building(
            nameOfBuilding = "ЖК Притяжение",
            address = "ул. Александра Матросова, д. 3, стр. 1",
            nameOfResponsiblePerson = "Навалихин Сергей Викторович"
        )
        val building2 = Building(
            nameOfBuilding = "Tarmo",
            address = "Студенческая ул., 24",
            nameOfResponsiblePerson = "Навалихин Сергей Викторович"
        )
        val building3 = Building(
            nameOfBuilding = "ПИК / Орловский парк",
            address = "пересечение Орлово-Денисовского проспекта и, Суздальское ш.",
            nameOfResponsiblePerson = "Навалихин Сергей Викторович"
        )
        addBuilding(building1)
        addBuilding(building2)
        addBuilding(building3)

}

override fun addBuilding(building: Building) {
    if (building.id == Building.UNDEFINED_ID) {
        building.id = autoIncrement++
    }
    buildingsList.add(building)
    updateLD()
}

override fun getBuilding(id: Int): Building {
    return buildingsList.find {
        it.id == id
    } ?: throw RuntimeException("Invalid Building ID: $id")
}

override fun getAllBuildings(): LiveData<List<Building>> {
    return buildingsLD
}

private fun updateLD() {
    buildingsLD.value = buildingsList.toList()
}
}