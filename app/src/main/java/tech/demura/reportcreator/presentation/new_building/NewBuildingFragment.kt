package tech.demura.reportcreator.presentation.new_building

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import tech.demura.reportcreator.databinding.FragmentNewBuildingBinding


class NewBuildingFragment : Fragment() {

    private var _binding: FragmentNewBuildingBinding? = null
    val binding: FragmentNewBuildingBinding
        get() = _binding ?: throw RuntimeException("FragmentAddBuildingBinding == null")

    private val newBuildingViewModel: NewBuildingViewModel by lazy {
        ViewModelProvider(this)[NewBuildingViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewBuildingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addChangeTextListeners()
        binding.newBuildingViewModel = newBuildingViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.btnSaveBuilding.setOnClickListener {
            newBuildingViewModel.AddBuilding(
                binding.etNameOfBuilding.text.toString(),
                binding.etNameOfResponsiblePerson.text.toString(),
                binding.etAddress.text.toString()
            )
        }
        newBuildingViewModel.shouldCloseScreen.observe(viewLifecycleOwner){
            backToBuildingList()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun backToBuildingList(){
        findNavController().popBackStack()
    }

    private fun addChangeTextListeners() {
        binding.etNameOfBuilding.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                newBuildingViewModel.resetErrorInputByildingName()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.etNameOfResponsiblePerson.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                newBuildingViewModel.resetErrorInputResponsiblePerson()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.etAddress.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                newBuildingViewModel.resetErrorInputAddress()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

}