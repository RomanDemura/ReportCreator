package tech.demura.reportcreator.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Report(
    val date: String,
    val building: String,
    val countOfRegularWorkers: Int,
    val countOfNotRegularWorkers: Int,
    val actions: List<Action>
) : Parcelable