package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class GetActionListUseCase(private val repository: BuildingInfoRepository) {
    fun getActionList(): List<BuildingInfo>{
        return repository.getActionList()
    }
}