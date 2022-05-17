package tech.demura.reportcreator.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import tech.demura.reportcreator.R
import tech.demura.reportcreator.databinding.FragmentResult2Binding


class ResultFragment : Fragment() {

    private val args by navArgs<ResultFragmentArgs>()
    var result = ""
    lateinit var context1: Context

    private var _binding: FragmentResult2Binding? = null
    val binding: FragmentResult2Binding
    get() = _binding ?: throw RuntimeException("binding result == null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context1 = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResult2Binding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResult()
        binding.result = result
        binding.btnSend.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.setPackage("com.whatsapp")
            if (intent != null){
                intent.putExtra(Intent.EXTRA_TEXT, result)
                startActivity(Intent.createChooser(intent,result))
            } else {
                Toast.makeText(context1,"Не удалось отправить сообщение в WhatsUp.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getResult(){
        result = """Дата: ${args.report.date}
        |Объект: ${args.report.building}
        |Рабочих: ${args.report.countOfRegularWorkers}
        |Смена: ${args.report.countOfNotRegularWorkers}часов
        |Общее: ${args.report.countOfRegularWorkers * args.report.countOfNotRegularWorkers}часов
    """.trimMargin()
        if (args.report.actions.isNotEmpty())
            result += "\nВыполненные задачи:\n"
        for (action in args.report.actions){
            result += action.text
            result += "\n"
        }
    }

}