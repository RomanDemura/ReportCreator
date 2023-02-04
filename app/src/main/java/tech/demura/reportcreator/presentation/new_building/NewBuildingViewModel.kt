package tech.demura.reportcreator.presentation.new_building

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.BuildingRepositoryImpl
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building.use_case.AddBuildingUseCase

class NewBuildingViewModel : ViewModel() {
    private val buildingRepository = BuildingRepositoryImpl

    private val addBuildingUseCase = AddBuildingUseCase(buildingRepository)

    private var _errorInputByildingName = MutableLiveData<Boolean>()
    val errorInputByildingName: LiveData<Boolean>
        get() = _errorInputByildingName

    private val _errorInputResponsiblePerson = MutableLiveData<Boolean>()
    val errorInputResponsiblePerson: LiveData<Boolean>
        get() = _errorInputResponsiblePerson

    private val _errorInputAddress = MutableLiveData<Boolean>()
    val errorInputAddress: LiveData<Boolean>
        get() = _errorInputAddress

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen


    fun AddBuilding(nameOfBuilding: String, nameOfResponsiblePerson: String, address: String) {
        val isValid = validateInput(nameOfBuilding, nameOfResponsiblePerson, address)
        if (isValid) {
            val building = Building(
                nameOfBuilding = nameOfBuilding,
                nameOfResponsiblePerson = nameOfResponsiblePerson,
                address = address
            )
            addBuildingUseCase.addBuilding(building)
            finishWork()
        }
    }

    private fun validateInput(nameOfBuilding: String, nameOfResponsiblePerson: String, address: String): Boolean {
        var result = true

        if (nameOfBuilding.isBlank()) {
            _errorInputByildingName.value = true
            result = false
        }
        if (nameOfResponsiblePerson.isBlank()) {
            _errorInputResponsiblePerson.value = true
            result = false
        }
        if (address.isBlank()) {
            _errorInputAddress.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputByildingName() {
        _errorInputByildingName.value = false
    }

    fun resetErrorInputResponsiblePerson() {
        _errorInputResponsiblePerson.value = false
    }

    fun resetErrorInputAddress() {
        _errorInputAddress.value = false
    }


    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}