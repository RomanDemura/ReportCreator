package tech.demura.reportcreator.domain.reports_plant.repository

import androidx.lifecycle.LiveData
import tech.demura.reportcreator.domain.plant.entites.Plant
import tech.demura.reportcreator.domain.reports_plant.entites.ReportsPlant

interface ReportsPlantRepository {
    fun addPlantAsReportsPlant(plant: Plant, reportId: Int)

    fun addReportsPlant(reportsPlant: ReportsPlant)

    fun updateReportsPlant(reportsPlant: ReportsPlant)

    fun getAllReportsPlants(reportId: Int): LiveData<List<ReportsPlant>>

    fun submitChangedReportsPlants()

    fun changeReportsPlant(newPlant: ReportsPlant)
}