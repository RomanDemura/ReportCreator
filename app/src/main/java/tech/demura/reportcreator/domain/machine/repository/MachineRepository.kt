package tech.demura.reportcreator.domain.machine.repository

import tech.demura.reportcreator.domain.machine.entites.Machine

interface MachineRepository {

    fun addMachine(machine: Machine)

    fun getMachine(id: Int): Machine

    fun getBuildingMachines(buildingId: Int): List<Machine>
}