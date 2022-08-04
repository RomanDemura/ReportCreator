package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.machine.repository.MachineRepository

object MachineRepositoryImpl: MachineRepository {

    val machineLD = MutableLiveData<List<Machine>>()
    val machineList = sortedSetOf<Machine>({o1, o2 -> o1.id.compareTo(o2.id)})
    var autoIncrement = 0

    init {
        updateLD()
        val machine = Machine(buildingId = 0, name = "Volga")
        addMachine(machine)
    }


    override fun addMachine(machine: Machine) {
        if (machine.id == Machine.UNDEFINED_ID){
            machine.id = autoIncrement++
        }
        machineList.add(machine)
        updateLD()
    }

    override fun getMachine(id: Int): Machine {
        return machineList.find { it.id == id } ?: throw RuntimeException("Invalid machine ID")
    }

    override fun getBuildingMachines(buildingId: Int): List<Machine> {
        return machineLD.value ?: throw RuntimeException("Machine list does not exist")
    }

    fun updateLD(){
        machineLD.value = machineList.toList()
    }


}