package tech.demura.reportcreator.presentation.add_plant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import tech.demura.reportcreator.databinding.FragmentAddPlantBinding

class AddPlantFragment : Fragment() {

    private val args by navArgs<AddPlantFragmentArgs>()

    private var _binding: FragmentAddPlantBinding? = null
    val binding: FragmentAddPlantBinding
        get() = _binding ?: throw RuntimeException("FragmentAddPlantBinding == null")

    private val addPlantViewModel: AddPlantViewModel by lazy {
        ViewModelProvider(this)[AddPlantViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddPlant.setOnClickListener {
            addPlantViewModel.addPlant(
                buildingId = args.buildingId,
                plantName = binding.etNameOfPlant.text.toString(),
                importedPlants = binding.etImportPlants.text.toString().toInt(),
                usagePlants = binding.etUsagePlants.text.toString().toInt()
            )
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}