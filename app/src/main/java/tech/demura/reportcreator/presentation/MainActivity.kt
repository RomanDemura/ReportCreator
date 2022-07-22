package tech.demura.reportcreator.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.demura.reportcreator.R
import tech.demura.reportcreator.data.BuildingRepositoryImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BuildingRepositoryImpl.getAllBuildings()
    }
}