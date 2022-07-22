package tech.demura.reportcreator.domain.report.entites

import tech.demura.reportcreator.domain.action.entites.Action
import tech.demura.reportcreator.domain.machine.entites.Machine
import tech.demura.reportcreator.domain.plant.entites.Plant
import java.util.*


data class Report(
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
)