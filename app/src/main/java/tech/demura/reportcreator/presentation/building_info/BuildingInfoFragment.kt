package tech.demura.reportcreator.presentation.building_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.FragmentBuildingInfoBinding
import tech.demura.reportcreator.presentation.plant_list.PlantListAdapter
import tech.demura.reportcreator.presentation.plant_list.PlantListViewModel

class BuildingInfoFragment : Fragment() {

    private val plantListViewModel: PlantListViewModel by lazy {
        ViewModelProvider(this)[PlantListViewModel::class.java]
    }
    private val plantListAdapter: PlantListAdapter by lazy {
        PlantListAdapter()
    }

    private var _binding: FragmentBuildingInfoBinding? = null
    private val binding: FragmentBuildingInfoBinding
    get() = _binding ?: throw RuntimeException("FragmentBuildingInfoBinding == null")




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBuildingInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}