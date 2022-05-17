package tech.demura.reportcreator.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.FragmentCreateReport2Binding

class CreateReportFragment : Fragment() {

    private lateinit var viewModel: CreateReportViewModel

    private var _binding: FragmentCreateReport2Binding? = null
    val binding: FragmentCreateReport2Binding
    get() = _binding ?: throw RuntimeException("Binding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateReportViewModel::class.java]
        _binding = FragmentCreateReport2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        binding.btnResult.setOnClickListener {
            setParams()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchResult(){
        findNavController().navigate(
            CreateReportFragmentDirections
                .actionCreateReportFragmentToResultFragment(viewModel.getReport())
        )
    }

    private fun setParams(){
        val acGr = binding.cbAcceptedGrunt.isChecked
        val acPl = binding.cbAcceptedPlants.isChecked
        val plPl = binding.cbPlantedPlants.isChecked
        viewModel.click(
            binding.etDate.text.toString(),
            binding.etBuilding.text.toString(),
            binding.etWorkers.text.toString(),
            binding.etHours.text.toString(),
            acGr, acPl, plPl
        )
    }

    private fun setObservers(){
        viewModel.errorDate.observe(viewLifecycleOwner){
            if (it){
                binding.tilDate.error = "Неверное значение"
            } else
                binding.tilDate.error = null
        }

        viewModel.errorBuilding.observe(viewLifecycleOwner){
            if (it){
                binding.tilBuilding.error = "Неверное значение"
            } else
                binding.tilBuilding.error = null
        }

        viewModel.errorWorkers.observe(viewLifecycleOwner){
            if (it){
                binding.tilWorkers.error = "Неверное значение"
            } else
                binding.tilWorkers.error = null
        }

        viewModel.errorHours.observe(viewLifecycleOwner){
            if (it){
                binding.tilHours.error = "Неверное значение"
            } else
                binding.tilHours.error = null
        }

        viewModel.goNext.observe(viewLifecycleOwner){
            launchResult()
        }
    }
}