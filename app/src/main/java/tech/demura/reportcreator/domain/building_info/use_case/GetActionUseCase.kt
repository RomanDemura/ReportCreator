package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository


class GetActionUseCase(private val repository: BuildingInfoRepository) {
    fun getAction(actionId: Int): BuildingInfo {
        return repository.getAction(actionId)
    }
}