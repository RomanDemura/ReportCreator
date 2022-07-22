package tech.demura.reportcreator.domain.dirt.use_case

import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.repository.DirtRepository

class UpdateDirtInfoUseCase(private val repository: DirtRepository) {

    fun updateDirtInfo(dirt: Dirt){
        repository.updateDirtInfo(dirt)
    }
}