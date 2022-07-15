package tech.demura.reportcreator.domain.building_info.use_case

import tech.demura.reportcreator.domain.building_info.repository.BuildingInfoRepository

class UpdateDirtInfoUseCase(private val repository: BuildingInfoRepository) {
    fun updateDirtInfo(import: Int, export: Int, usage: Int){
        repository.updateDirtInfo(import, export, usage)
    }
}