package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class CreateActionUseCase (private val repository: BuildingInfoRepository) {
    fun createAction(text: String, value: Int): BuildingInfo {
        return repository.createAction(text, value)
    }
}