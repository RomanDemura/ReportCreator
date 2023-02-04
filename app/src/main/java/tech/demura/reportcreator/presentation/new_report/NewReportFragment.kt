package tech.demura.reportcreator.presentation.new_report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import tech.demura.reportcreator.databinding.FragmentNewReportBinding
import tech.demura.reportcreator.presentation.plant_list.PlantListAdapter
import tech.demura.reportcreator.presentation.plant_list.PlantListViewModel

class NewReportFragment : Fragment() {

    private val args by navArgs<NewReportFragmentArgs>()

    private var _binding: FragmentNewReportBinding? = null
    val binding: FragmentNewReportBinding
        get() =
            _binding ?: throw RuntimeException("FragmentNewReportBinding is null")

    private val newReportViewModel by lazy {
        ViewModelProvider(this)[NewReportViewModel::class.java]
    }

    // RV for Plants
    private val plantListAdapter = PlantListAdapter()
    private val plantListViewModel: PlantListViewModel by lazy {
        ViewModelProvider(this)[PlantListViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewReportBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddPlantToReport.setOnClickListener {
            //launcher.launch(pla)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private val EXTRA_PLANT_NAME = "plant_name"
    }
}