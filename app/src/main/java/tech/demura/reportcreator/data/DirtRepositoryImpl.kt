package tech.demura.reportcreator.data

import androidx.lifecycle.MutableLiveData
import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.repository.DirtRepository

object DirtRepositoryImpl : DirtRepository {

    private var dirtLD = MutableLiveData<List<Dirt>>()
    private var dirtList = sortedSetOf<Dirt>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrement = 0

    override fun addDirtInfo(dirt: Dirt): Dirt {
        if (dirt.id == Dirt.UNDEFINED_ID){
            dirt.id = autoIncrement++
        }
        dirtList.add(dirt)
        updateLD()
        return dirt
    }

    override fun deleteDirtInfo(dirt: Dirt) {
        dirtList.remove(dirt)
        updateLD()
    }

    override fun getDirtInfo(buildingId: Int): Dirt {
        var dirtInfo = dirtList.find{
            it.buildingId == buildingId
        }
        if (dirtInfo == null){
            dirtInfo = Dirt(buildingId = buildingId)
            dirtInfo = addDirtInfo(dirtInfo)
            updateLD()
            return dirtInfo
        } else
            return dirtInfo
    }

    override fun updateDirtInfo(dirt: Dirt) {
        var oldDirtInfo = getDirtInfo(dirt.buildingId)
        deleteDirtInfo(oldDirtInfo)
        addDirtInfo(dirt)
        updateLD()
    }

    private fun updateLD(){
        dirtLD.value = dirtList.toList()
    }
}