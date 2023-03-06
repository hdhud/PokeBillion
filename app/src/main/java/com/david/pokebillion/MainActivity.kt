package com.david.pokebillion

import android.os.Bundle
import android.view.View
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
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val rootView = findViewById<View>(android.R.id.content)
        rootView.setOnTouchListener { _, event ->
            val random = randomINT(0,1000000000)
            System.out.println("Random : $random")
            if (random%250==0){
                System.out.println("Random % $250")
            }
            if (random%500==0){
                System.out.println("Random % $500")
            }
            if (random%1000==0){
                System.out.println("Random % $1000")
            }
            if (random%2000==0){
                System.out.println("Random % $2000")
            }
            if (random%5000==0){
                System.out.println("Random % $5000")
            }
            if (random%10000==0){
                System.out.println("Random % $10000")
            }
            if (random%25000==0){
                System.out.println("Random % $25000")
            }
            if (random%50000==0){
                System.out.println("Random % $50000")
            }
            if (random%75000==0){
                System.out.println("Random % $75000")
            }
            if (random%100000==0){
                System.out.println("Random % $100000")
            }
            if (random%250000==0){
                System.out.println("Random % $250000")
            }
            if (random%500000==0){
                System.out.println("Random % $500000")
            }
            if (random%1000000==0){
                System.out.println("Random % $1000000")
            }
            if (random%5000000==0){
                System.out.println("Random % $5000000")
            }
            if (random%10000000==0){
                System.out.println("Random % $10000000")
            }
            if (random%100000000==0){
                System.out.println("Random % $100000000")
            }
            if (random%1000000000==0){
                System.out.println("Random % $1000000000")
            }


            return@setOnTouchListener false
        }
    }
    public fun randomINT(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }
}