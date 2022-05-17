package tech.demura.reportcreator.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.domain.Action
import tech.demura.reportcreator.domain.Report

class CreateReportViewModel : ViewModel() {

    private var date: String = ""
    private var building: String = ""
    private var workers: Int = 0
    private var hours: Int = 0
    private var acceptGrunt: Boolean = false
    private var acceptPlants: Boolean = false
    private var plantedPlants: Boolean = false

    var _errorDate = MutableLiveData<Boolean>()
    val errorDate: LiveData<Boolean>
        get() = _errorDate

    var _errorBuilding = MutableLiveData<Boolean>()
    val errorBuilding: LiveData<Boolean>
        get() = _errorBuilding

    var _errorWorkers = MutableLiveData<Boolean>()
    val errorWorkers: LiveData<Boolean>
        get() = _errorWorkers

    var _errorHours = MutableLiveData<Boolean>()
    val errorHours: LiveData<Boolean>
        get() = _errorHours

    var goNext = MutableLiveData<Boolean>()

    val valid: Boolean
        get() = errorDate.value == false && errorBuilding.value == false && errorWorkers.value == false && errorHours.value == false

    fun click(
        date: String,
        building: String,
        workers: String,
        hours: String,
        acceptGrunt: Boolean,
        acceptPlants: Boolean,
        plantedPlants: Boolean
    ) {
        parseParams(
            date,
            building,
            workers,
            hours,
            acceptGrunt,
            acceptPlants,
            plantedPlants
        )
        if(valid){
            goNext.value = valid
        }
    }

    fun parseParams(
        date: String,
        building: String,
        workers: String,
        hours: String,
        acceptGrunt: Boolean,
        acceptPlants: Boolean,
        plantedPlants: Boolean
    ) {
        this.date = date
        _errorDate.value = date.isEmpty()

        this.building = building
        _errorBuilding.value = building.isEmpty()

        if(workers.isNotEmpty()){
            this.workers = workers.toInt()
            _errorWorkers.value = this.workers <= 0
        } else {
            _errorWorkers.value = true
        }

        if(hours.isNotEmpty()){
            this.hours = hours.toInt()
            _errorHours.value = this.workers <= 0
        } else {
            _errorHours.value = true
        }

        this.acceptGrunt = acceptGrunt
        this.acceptPlants = acceptPlants
        this.plantedPlants = plantedPlants
    }

    fun getReport(): Report {
        var listActions = mutableListOf<Action>()
        if (acceptGrunt) {
            listActions.add(Action("Принял 25 м3 грунта", 0.0))
        }
        if (acceptPlants) {
            listActions.add(Action("Принял 250 растений: Пузыреплодник", 0.0))
        }
        if (plantedPlants) {
            listActions.add(Action("Посажено 250 растений: Пузыреплодник", 0.0))
        }
        return Report(date, building, workers, hours, listActions)
    }

}