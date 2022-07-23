package tech.demura.reportcreator.domain.dirt.repository

import tech.demura.reportcreator.domain.dirt.entites.Dirt

interface DirtRepository {

    fun addDirtInfo(dirt: Dirt): Dirt

    fun deleteDirtInfo(dirt: Dirt)

    fun getDirtInfo(buildingId: Int): Dirt

    fun updateDirtInfo(dirt: Dirt)
}