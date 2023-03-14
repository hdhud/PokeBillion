package com.david.pokebillion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext

class CarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carte)

        val carte = intent.getSerializableExtra("carte") as Carte
        //println(carte)
        val nomcarte = findViewById<TextView>(R.id.nom_carte)
        nomcarte.text = carte.nom
        val raretecarte = findViewById<TextView>(R.id.rarete_carte)
        raretecarte.text = "1/${carte.Rarete}"
        val nbcarte = findViewById<TextView>(R.id.nb_carte)
        nbcarte.text = " ${carte.nb_carte}"
        val nbtotalcarte = findViewById<TextView>(R.id.nb_total_carte)
        nbtotalcarte.text = " ${carte.nb_Total}"
        val vendre = findViewById<TextView>(R.id.Vendre)
        vendre.setOnClickListener {
            carte.vendre(1)
            nbcarte.text = " ${carte.nb_carte}"
            nbtotalcarte.text = " ${carte.nb_Total}"
            val intent = Intent(this, Vendre::class.java)

            intent.putExtra("carte", carte)
            startActivity(intent)
        }
    }
}