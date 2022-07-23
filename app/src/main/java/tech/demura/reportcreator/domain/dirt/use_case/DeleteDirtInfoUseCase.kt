package tech.demura.reportcreator.domain.dirt.use_case

import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.repository.DirtRepository

class DeleteDirtInfoUseCase(private val repository: DirtRepository) {

    fun deleteDirtInfo(dirt: Dirt){
        repository.deleteDirtInfo(dirt)
    }
}