package com.david.pokebillion

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.david.pokebillion.databinding.ActivityMainBinding
import com.david.pokebillion.profil.getcarteList
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.*
// import pokemontcg api




class MainActivity : AppCompatActivity() {

    val context: Context = this

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("profil", MODE_PRIVATE)
        val argent = sharedPreferences.getInt("argent", 0)
        val clickjour = sharedPreferences.getInt("click_jour", 0)
        val clicktotal = sharedPreferences.getInt("click_total", 0)
        Log.d("MainActivity", "Argent : $argent")
        Log.d("MainActivity", "Click Jour : $clickjour")
        Log.d("MainActivity", "Click Total : $clicktotal")
        profil.argent = argent
        profil.clickjour = clickjour
        profil.clicktotal = clicktotal

    }
    
    override fun onStop() {
        super.onStop()
        val carteList = getcarteList()
        if (carteList.isNotEmpty()) {
            Carte.saveData(carteList)
        }
        val sharedPreferences: SharedPreferences = getSharedPreferences("profil", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.putInt("click_total",profil.clicktotal )
        editor.putInt("argent", profil.argent)
        editor.putInt("click_jour", profil.clickjour)
        editor.apply()
        editor.commit()
    }
}