package tech.demura.reportcreator.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.plant.repository.PlantRepository

object PlantRepositoryImpl: PlantRepository {

    val plantLD = MutableLiveData<List<Plant>>()
    val plantList = sortedSetOf<Plant>({o1, o2 -> o1.id.compareTo(o2.id)})
    var autoIncrement = 0

    init {
        updateLD()
        val plant1 = Plant(buildingId = 0, name = "Толокнянка обыкновенная", importedPlants = 150, usagePlants = 50, reportId = -1)
        val plant2 = Plant(buildingId = 0, name = "Бетелевая пальма", importedPlants = 200, usagePlants = 0, reportId = -1)
        val plant3 = Plant(buildingId = 0, name = "Арнебия красящая", importedPlants = 300, usagePlants = 300, reportId = -1)
        val plant4 = Plant(buildingId = 0, name = "Арника горная", importedPlants = 50, usagePlants = 50, reportId = -1)
        val plant5 = Plant(buildingId = 0, name = "Борец свирепый", importedPlants = 0, usagePlants = 0, reportId = -1)
        val plant6 = Plant(buildingId = 0, name = "Кокорыш обыкновенный", importedPlants = 76, usagePlants = 62, reportId = -1)
        addPlant(plant1)
        addPlant(plant2)
        addPlant(plant3)
        addPlant(plant4)
        addPlant(plant5)
        addPlant(plant6)
    }

    override fun addPlant(plant: Plant) {
        if (plant.id == Plant.UNDEFINED_ID){
            plant.id = autoIncrement++
        }
        plantList.add(plant)
    }

    override fun getPlant(id: Int): Plant {
        return plantList.find{
            it.id == id
        } ?: throw RuntimeException("Invalid plant ID: $id")
    }

    override fun deletePlant(plant: Plant) {
        plantList.remove(plant)
    }

    override fun updatePlant(plant: Plant) {
        val oldPlant = plantList.find{it.id == plant.id}
        if (oldPlant == null)
            throw RuntimeException("Invalid plant ID: ${plant.id}")
        plantList.remove(oldPlant)
        plantList.add(plant)
    }



    override fun getBuildingPlants(buildingId: Int): LiveData<List<Plant>> {
        plantLD.value = plantList.filter { it.buildingId == buildingId }
        return plantLD
    }

    private fun updateLD(){
        plantLD.value = plantList.toList()
    }
}