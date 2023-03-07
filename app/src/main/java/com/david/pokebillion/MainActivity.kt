package com.david.pokebillion

import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.david.pokebillion.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

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
        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnTouchListener { _, event ->
            val random = randomINT(0,1000000000)
            //System.out.println("Random : $random")

            val modulos = listOf(250, 500, 1000, 2000, 5000, 10000, 25000, 50000, 75000, 100000, 250000, 500000, 1000000, 5000000, 10000000, 100000000, 1000000000)
            var trouver = false
            var modulo = 0
            for (m in modulos) {
                if (random % m == 0) {
                    trouver = true
                    modulo = m
                }
            }
            if (trouver) {
                System.out.println("Random : $random")
                System.out.println("Modulo : $modulo")
            }



            return@setOnTouchListener false
        }

    }
    public fun randomINT(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }

}