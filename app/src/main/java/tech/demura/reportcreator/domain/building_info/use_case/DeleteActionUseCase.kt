package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class DeleteActionUseCase(private val repository: BuildingInfoRepository) {
    fun deleteAction(action: BuildingInfo){
        repository.deleteAction(action)
    }
}