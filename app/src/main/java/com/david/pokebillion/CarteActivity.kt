package com.david.pokebillion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carte)

        val carte = intent.getSerializableExtra("carte") as Carte
        println(carte)
        val nomcarte = findViewById<TextView>(R.id.nom_carte)
        nomcarte.text = carte.nom
        val raretecarte = findViewById<TextView>(R.id.rarete_carte)
        raretecarte.text = "1/${carte.Rarete}"
        val nbcarte = findViewById<TextView>(R.id.nb_carte)
        nbcarte.text = " ${carte.nb_carte}"
        val nbtotalcarte = findViewById<TextView>(R.id.nb_total_carte)
        nbtotalcarte.text = " ${carte.nb_Total}"
    }
}