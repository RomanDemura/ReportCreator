package tech.demura.reportcreator.domain.report.entites

import tech.demura.reportcreator.domain.plant.entites.Plant


data class Report(
    var id: Int = Plant.UNDEFINED_ID,
    var buildingId: Int,
    var date: Long = 0L,                         // Дата
    var countOfRegularWorkers: Int = 0,         // Штатные сотрудники
    var countOfNotRegularWorkers: Int = 0,      // Рабочий класс
    var countOfSocialWorkers: Int = 0,          // Социальные рабочие
    var workShift: Int = 0,                     // Рабочая смена
    var dirtImport: Int = 0,                    // Грунта получено
    var dirtExport: Int = 0,                    // Грунта увезено
    var dirtUsage: Int = 0                     // Грунта использовано
//    var plantsList: List<Plant>,            // Список растений
//    var machines: List<Machine>,            // Список использованной техники
//    var anotherActions: List<Action>        // Список дополнительных действий
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}