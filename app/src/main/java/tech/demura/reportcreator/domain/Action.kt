package tech.demura.reportcreator.domain

data class Action (
    val action: String = "Default Action name",
    val value: Int = 0,
    val unitsOfMeasure: String = "uof"
)