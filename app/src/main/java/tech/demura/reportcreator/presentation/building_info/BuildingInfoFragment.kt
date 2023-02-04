package tech.demura.reportcreator.presentation.building_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import tech.demura.reportcreator.databinding.FragmentBuildingInfoBinding
import tech.demura.reportcreator.presentation.plant_list.PlantListAdapter
import tech.demura.reportcreator.presentation.plant_list.PlantListViewModel
import tech.demura.reportcreator.presentation.report_list.ReportListAdapter
import tech.demura.reportcreator.presentation.report_list.ReportListViewModel

class BuildingInfoFragment : Fragment() {

    private val args by navArgs<BuildingInfoFragmentArgs>()

    private var _binding: FragmentBuildingInfoBinding? = null
    private val binding: FragmentBuildingInfoBinding
        get() = _binding ?: throw RuntimeException("FragmentBuildingInfoBinding == null")

    // Building Info
    private val buildingInfoViewModel: BuildingInfoViewModel by lazy {
        ViewModelProvider(this)[BuildingInfoViewModel::class.java]
    }

    // RV for Plants
    private val plantListAdapter = PlantListAdapter()
    private val plantListViewModel: PlantListViewModel by lazy {
        ViewModelProvider(this)[PlantListViewModel::class.java]
    }

    // RV for Reports
    private val reportListAdapter = ReportListAdapter()
    private val reportListViewModel: ReportListViewModel by lazy {
        ViewModelProvider(this)[ReportListViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        binding.btnAddPlant.setOnClickListener {
            launchAddPlant()
        }
        binding.btnAddReport.setOnClickListener {
            launchAddReport()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupObservers() {

        // Building
        buildingInfoViewModel.getBuilding(args.building)
        buildingInfoViewModel.buildingLD.observe(viewLifecycleOwner) {
            binding.building = it
        }

        // Dirt Info
        buildingInfoViewModel.getDirtInfo(args.building.id)
        buildingInfoViewModel.dirtInfoLD.observe(viewLifecycleOwner) {
            binding.dirt = it
        }

        // RV for plant list
        plantListViewModel.getBuildingPlants(args.building.id)
        binding.rvPlantList.adapter = plantListAdapter
        plantListViewModel.plantsList.observe(viewLifecycleOwner) {
            plantListAdapter.submitList(it)
        }

        // RV for report list
        reportListViewModel.getBuildingReports(args.building.id)
        binding.rvReportList.adapter = reportListAdapter
        reportListViewModel.reportList.observe(viewLifecycleOwner) {
            reportListAdapter.submitList(it)
        }
    }

    private fun launchAddPlant() {
        findNavController().navigate(
            BuildingInfoFragmentDirections.actionBuildingInfoFragmentToAddPlantFragment(
                args.building.id
            )
        )
    }

    private fun launchAddReport() {
        findNavController().navigate(
            BuildingInfoFragmentDirections.actionBuildingInfoFragmentToNewReportFragment(
                args.building
            )
        )
    }
}