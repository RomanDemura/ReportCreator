package tech.demura.reportcreator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tech.demura.reportcreator.R
import tech.demura.reportcreator.data.ReportRepositoryImpl
import tech.demura.reportcreator.domain.GetReportUseCase

class MainActivity : AppCompatActivity() {

//    private val repository = ReportRepositoryImpl
//    private val report = GetReportUseCase(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Log.d("Report", report.getReport())

    }
}