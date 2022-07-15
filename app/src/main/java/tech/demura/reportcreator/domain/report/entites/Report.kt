package tech.demura.reportcreator.domain.report.entites

import tech.demura.reportcreator.domain.Action
import tech.demura.reportcreator.domain.Machine
import tech.demura.reportcreator.domain.Plant
import tech.demura.reportcreator.domain.building.entites.Building
import tech.demura.reportcreator.domain.building_info.entites.BuildingInfo
import java.util.*


data class Report(
    val building: Building,                 // Объект
    val date: Date,                         // Дата
    val countOfRegularWorkers: Int,         // Штатные сотрудники
    val countOfNotRegularWorkers: Int,      // Рабочий класс
    val countOfSocialWorkers: Int,          // Социальные рабочие
    val workShift: Int,                     // Рабочая смена
    val dirtImport: Int,                    // Грунта получено
    val dirtExport: Int,                    // Грунта увезено
    val dirtUsage: Int,                     // Грунта использовано
    val plantsList: List<Plant>,            // Список растений
    val machines: List<Machine>,            // Список использованной техники
    val anotherActions: List<Action>,       // Список дополнительных действий

    val id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}