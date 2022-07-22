package tech.demura.reportcreator.domain.machine.use_case

import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.machine.repository.MachineRepository

class GetMachineUseCase(private val repository: MachineRepository) {

    fun getMachine(id: Int): Machine {
        return repository.getMachine(id)
    }
}