package tech.demura.reportcreator.presentation.building_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.demura.reportcreator.data.DirtRepositoryImpl
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.dirt.entites.Dirt
import tech.demura.reportcreator.domain.dirt.use_case.GetDirtInfoUseCase

class BuildingInfoViewModel: ViewModel() {
    private val dirtRepository = DirtRepositoryImpl

    private val getDirtInfoUseCase = GetDirtInfoUseCase(dirtRepository)

    lateinit var buildingLD: LiveData<Building>
    lateinit var dirtInfoLD: LiveData<Dirt>

    fun getBuilding(building: Building){
        buildingLD = MutableLiveData(building)
    }
    fun getDirtInfo(buildingId: Int){
        dirtInfoLD = MutableLiveData(getDirtInfoUseCase.getDirtInfo(buildingId))
    }
}