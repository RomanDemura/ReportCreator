package tech.demura.reportcreator.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant
import tech.demura.reportcreator.domain.reports_plant.repository.ReportsPlantRepository

object ReportsPlantRepositoryImpl: ReportsPlantRepository {

    private var reportsPlantLD = MutableLiveData<List<ReportsPlant>>(listOf())
    private var reportsPlantList = sortedSetOf<ReportsPlant>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var tempReportsPlantList = sortedSetOf<ReportsPlant>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    init {

    }



    override fun addPlantAsReportsPlant(plant: Plant, reportId: Int) {
        val reportsPlant = ReportsPlant(reportId = reportId,name = plant.name)
        addReportsPlant(reportsPlant)
    }


    override fun addReportsPlant(reportsPlant: ReportsPlant) {
        if (reportsPlant.id == ReportsPlant.UNDEFINED_ID){
            reportsPlant.id = autoIncrement++
        }
        tempReportsPlantList.add(reportsPlant)
        updateLD()
    }

    override fun updateReportsPlant(reportsPlant: ReportsPlant) {
        val oldReportsPlant = tempReportsPlantList.find { it.id == reportsPlant.id }
        tempReportsPlantList.remove(oldReportsPlant)
        tempReportsPlantList.add(reportsPlant)
        updateLD()
    }

    override fun getAllReportsPlants(reportId: Int): LiveData<List<ReportsPlant>> {
        val currentReportsPlantList = reportsPlantList.filter { it.id == reportId }
        tempReportsPlantList.clear()
        tempReportsPlantList.addAll(currentReportsPlantList)
        updateLD()

        return reportsPlantLD
    }

    override fun changeReportsPlant(newPlant: ReportsPlant) {
        val oldPlant = reportsPlantList.find { it.id == newPlant.id }
        reportsPlantList.remove(oldPlant)
        reportsPlantList.add(newPlant)
    }

    override fun submitChangedReportsPlants() {
        for (reportsPlant in tempReportsPlantList){
            val oldReportsPlant = reportsPlantList.find { it.id == reportsPlant.id }
            if (oldReportsPlant == null){
                reportsPlantList.add(reportsPlant)
            } else {
                reportsPlantList.remove(oldReportsPlant)
                reportsPlantList.add(reportsPlant)
            }
        }
    }

    private fun updateLD(){
        reportsPlantLD.value = tempReportsPlantList.toList()
    }
}