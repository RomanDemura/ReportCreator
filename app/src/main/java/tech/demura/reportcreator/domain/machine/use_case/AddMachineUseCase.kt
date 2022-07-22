package tech.demura.reportcreator.domain.machine.use_case

import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.machine.repository.MachineRepository

class AddMachineUseCase(private val repository: MachineRepository) {

    fun addMachine(machine: Machine){
        repository.addMachine(machine)
    }
}