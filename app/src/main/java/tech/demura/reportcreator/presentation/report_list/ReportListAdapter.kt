package tech.demura.reportcreator.presentation.report_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.ItemReportBinding
import tech.demura.reportcreator.domain.report.entites.Report

class ReportListAdapter: ListAdapter<Report, ReportListViewHolder>(ReportItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportListViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_report,
            parent,
            false
        )
        return ReportListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReportListViewHolder, position: Int) {
        val report = getItem(position)
        if (holder.binding is ItemReportBinding)
            holder.binding.report = report

    }
}