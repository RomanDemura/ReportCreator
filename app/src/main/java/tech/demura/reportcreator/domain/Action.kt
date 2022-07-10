package tech.demura.reportcreator.domain

data class Action (
    val action: String,
    val value: Int,
    val unitsOfMeasure: String,
    val withValue: Boolean
)