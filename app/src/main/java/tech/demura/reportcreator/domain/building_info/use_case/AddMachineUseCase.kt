package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class AddMachineUseCase(private val repository: BuildingInfoRepository) {
    fun addMachine(machine: Machine) {
        return repository.addMachine(machine = machine)
    }
}