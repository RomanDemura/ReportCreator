package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class EditActionUseCase(private val repository: BuildingInfoRepository) {
    fun editAction(action: BuildingInfo){
        repository.editAction(action)
    }
}