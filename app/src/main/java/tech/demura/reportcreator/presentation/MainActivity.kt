package tech.demura.reportcreator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import tech.demura.reportcreator.R
import tech.demura.reportcreator.data.BuildingRepositoryImpl
import tech.demura.reportcreator.data.DirtRepositoryImpl
import tech.demura.reportcreator.data.MachineRepositoryImpl
import tech.demura.reportcreator.data.PlantRepositoryImpl
import tech.demura.reportcreator.presentation.buildings_list.BuildingListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
