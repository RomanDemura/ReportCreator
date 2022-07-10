package tech.demura.reportcreator.domain.building_info.entites

import tech.demura.reportcreator.domain.Dirt
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.report.entites.Report

data class BuildingInfo(
    var plantsList: List<Plant>,
    var machineList: List<Machine>,
    var dirt: Dirt,
    var reports: List<Report>,

    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}