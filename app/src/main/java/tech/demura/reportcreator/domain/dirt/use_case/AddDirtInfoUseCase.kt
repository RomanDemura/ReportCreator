package tech.demura.reportcreator.domain.dirt.use_case

import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.repository.DirtRepository

class AddDirtInfoUseCase (private val repository: DirtRepository) {

    fun addDirtInfo(dirt: Dirt): Dirt{
        return repository.addDirtInfo(dirt)
    }
}