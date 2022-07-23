package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

object PlantRepositoryImpl: PlantRepository {

    val plantLD = MutableLiveData<List<Plant>>()
    val plantList = sortedSetOf<Plant>({o1, o2 -> o1.id.compareTo(o2.id)})
    var autoIncrement = 0

    override fun addPlant(plant: Plant) {
        if (plant.id == Plant.UNDEFINED_ID){
            plant.id = autoIncrement++
        }
        plantList.add(plant)
        updateLD()
    }

    override fun getPlant(id: Int): Plant {
        return plantList.find{
            it.id == id
        } ?: throw RuntimeException("Invalid plant ID: $id")
    }

    override fun deletePlant(plant: Plant) {
        plantList.remove(plant)
        updateLD()
    }

    override fun updatePlant(plant: Plant) {
        val oldPlant = plantList.find{it.id == plant.id}
        if (oldPlant == null)
            throw RuntimeException("Invalid plant ID: ${plant.id}")
        plantList.remove(oldPlant)
        plantList.add(plant)
        updateLD()
    }

    override fun getBuildingPlants(buildingId: Int): List<Plant> {
        return plantList.filter { it.buildingId == buildingId }
    }

    private fun updateLD(){
        plantLD.value = plantList.toList()
    }
}