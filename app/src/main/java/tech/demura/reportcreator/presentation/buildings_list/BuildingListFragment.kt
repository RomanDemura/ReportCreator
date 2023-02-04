package tech.demura.reportcreator.presentation.buildings_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import tech.demura.reportcreator.databinding.FragmentBuildingListBinding
import tech.demura.reportcreator.domain.building.entites.Building

class BuildingListFragment : Fragment() {

    private var _binding: FragmentBuildingListBinding? = null
    private val binding: FragmentBuildingListBinding
        get() = _binding ?: throw RuntimeException("FragmentBuildingListBinding == null")

    private val buildingListViewModel: BuildingListViewModel by lazy {
        ViewModelProvider(this)[BuildingListViewModel::class.java]
    }
    private val buildingListAdapter: BuildingListAdapter by lazy {
        BuildingListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRV()
        binding.btnAddBuilding.setOnClickListener {
            launchNewBuilding()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRV() {
        //RecyclerView for building list
        binding.rvBuildingList.adapter = buildingListAdapter
        buildingListViewModel.buildingList.observe(viewLifecycleOwner) {
            buildingListAdapter.submitList(it)
        }
        buildingListAdapter.onClickListener = {
            launchBuildingInfo(building = it)
        }
    }

    private fun launchNewBuilding() {
        findNavController().navigate(
            BuildingListFragmentDirections.actionBuildingListFragmentToAddBuildingFragment()
        )
    }

    private fun launchBuildingInfo(building: Building) {
        findNavController().navigate(
            BuildingListFragmentDirections.actionBuildingListFragmentToBuildingInfoFragment(
                building
            )
        )
    }
}