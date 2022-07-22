package tech.demura.reportcreator.domain.machine.use_case

import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.machine.repository.MachineRepository

class GetBuildingMachinesUseCase(private val repository: MachineRepository) {

    fun getBuildingMachines(buildingId: Int): List<Machine>{
        return repository.getBuildingMachines(buildingId)
    }
}