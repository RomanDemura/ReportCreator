package tech.demura.reportcreator.domain.dirt.use_case

import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.repository.DirtRepository

class GetDirtInfoUseCase(private val repository: DirtRepository) {

    fun getDirtInfo(buildingId: Int): Dirt {
        return repository.getDirtInfo(buildingId)
    }
}