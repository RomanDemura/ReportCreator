package tech.demura.reportcreator.presentation.plant_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.FragmentPlantListBinding

class PlantListFragment : Fragment() {

    private var buildingId: Int = 0

    private var _binding: FragmentPlantListBinding? = null
    private val binding: FragmentPlantListBinding
    get() = _binding ?: throw RuntimeException("FragmentPlantListBinding == null")

    private val plantListViewModel: PlantListViewModel by lazy {
        ViewModelProvider(this)[PlantListViewModel::class.java]
    }
    private val adapter = PlantListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parseParams()
        plantListViewModel.getBuildingPlants(buildingId)
        binding.rvPlantList.adapter = adapter
        plantListViewModel.plantsList.observe(viewLifecycleOwner){
            adapter.plantsList = it
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun parseParams(){
        val args = requireArguments()
        if (!args.containsKey(BUILDING_ID)){
            throw RuntimeException("Parameter Building ID is absent.")
        }
        buildingId = args.getInt(BUILDING_ID)
    }

    companion object{

        private const val BUILDING_ID = "building_id"

        fun newInstance(buildingId: Int): PlantListFragment{
            return PlantListFragment().apply {
                arguments = Bundle().apply {
                    putInt(BUILDING_ID, buildingId)
                }
            }
        }
    }


}