package tech.demura.reportcreator.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Action(
    var text: String,
    var value: Double,
    var id: Int = UNDEFINED_ID
) : Parcelable {
    companion object{
        const val UNDEFINED_ID = -1
    }
}