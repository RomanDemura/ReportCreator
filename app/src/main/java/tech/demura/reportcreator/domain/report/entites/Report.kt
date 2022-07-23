package tech.demura.reportcreator.domain.report.entites

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.plant.entites.Plant
import java.util.*


data class Report(
    var id: Int = Plant.UNDEFINED_ID,
    var buildingId: Int,
    var date: Date,                         // Дата
    var countOfRegularWorkers: Int,         // Штатные сотрудники
    var countOfNotRegularWorkers: Int,      // Рабочий класс
    var countOfSocialWorkers: Int,          // Социальные рабочие
    var workShift: Int,                     // Рабочая смена
    var dirtImport: Int,                    // Грунта получено
    var dirtExport: Int,                    // Грунта увезено
    var dirtUsage: Int,                     // Грунта использовано
    var plantsList: List<Plant>,            // Список растений
    var machines: List<Machine>,            // Список использованной техники
    var anotherActions: List<Action>,       // Список дополнительных действий
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}