package tech.demura.reportcreator.domain.report.repository

import tech.demura.reportcreator.domain.report.entites.Report

interface ReportRepository {

    fun addReport(report: Report)

    fun getReport(id: Int): Report

    fun getReportInfo(report: Report): String

    fun getBuildingReports(buildingId: Int): List<Report>
}