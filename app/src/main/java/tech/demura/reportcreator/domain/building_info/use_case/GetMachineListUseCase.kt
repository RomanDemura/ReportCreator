package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class GetMachineListUseCase(private val repository: BuildingInfoRepository) {
    fun getMachineList(): List<Machine>{
        return repository.getMachineList()
    }
}