package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository


class AddActiionUseCase(private val repository: BuildingInfoRepository) {
    fun addAction(action: BuildingInfo){
        repository.addAction(action)
    }
}
