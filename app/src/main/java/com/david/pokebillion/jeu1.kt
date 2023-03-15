package com.david.pokebillion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class jeu1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu1)
        ObtenirCarte(10000000)
    }
    fun ObtenirCarte(nombredeclique:Int){

        var maxrarete=0
        val modulos = listOf(
            250,
            500,
            1000,
            2000,
            5000,
            10000,
            25000,
            50000,
            75000,
            100000,
            250000,
            500000,
            1000000,
            5000000,
            10000000,
            100000000,
            1000000000
        )
        for (i in 0..nombredeclique ){
            val random = randomINT(0, 1000000000)
            for (j in modulos){
                if (random%j==0){
                    if (j>maxrarete){
                        maxrarete=j
                    }
                }
            }
        }
        println(maxrarete)
    }

    fun randomINT(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }
}