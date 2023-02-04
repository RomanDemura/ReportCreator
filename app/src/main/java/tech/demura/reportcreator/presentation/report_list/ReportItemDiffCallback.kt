package tech.demura.reportcreator.presentation.report_list

import androidx.recyclerview.widget.DiffUtil
import tech.demura.reportcreator.domain.report.entites.Report

class ReportItemDiffCallback: DiffUtil.ItemCallback<Report>() {
    override fun areItemsTheSame(oldItem: Report, newItem: Report): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Report, newItem: Report): Boolean {
        return oldItem == newItem
    }
}