package com.david.pokebillion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import java.lang.Integer.parseInt

class jeu1 : AppCompatActivity() {
    // Fonction pour obtenir une carte en utilisant le nombre de cliques
    fun obtenirCarte(nombredeclique:Int){

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

    // Fonction pour afficher la carte obtenue
    fun afficherCarte(carte: Carte) {
        // renvoie la carte obtenue

        Toast.makeText(this, carte.nom, Toast.LENGTH_SHORT).show()
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu1)
        ObtenirCarte(10000000)


        // Récupérer l'argent disponible dans le singleton Profil
        //val argentDisponible = profil.argent

        // Créer un curseur (slider) avec une plage de valeurs entre 0 et l'argent disponible
        val curseurArgent = findViewById<SeekBar>(R.id.curseur_argent)
        val curseurvaleur = findViewById<EditText>(R.id.editTextNumber)
        // Définir la plage de valeurs du curseur

        curseurArgent.max = 1000000
        // Définir la valeur initiale du curseur
        curseurArgent.progress = 0
        curseurvaleur.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (curseurvaleur.text.toString() != "") {

                    if (curseurvaleur.text.toString().toInt() > curseurArgent.max) {
                        curseurvaleur.setText(curseurArgent.max.toString())
                    }
                    curseurArgent.progress = curseurvaleur.text.toString().toInt()
                }
            }
        })
        curseurArgent.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                System.out.println(progress)
                curseurvaleur.setText(progress.toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        // Définir une action à effectuer lorsque l'utilisateur clique sur le bouton "Jouer"
        val boutonJouer = findViewById<Button>(R.id.bouton_jouer)
        boutonJouer.setOnClickListener {
            // Récupérer la somme d'argent choisie par l'utilisateur à partir du curseur
            val sommeArgent = curseurArgent.progress

            // Simuler le nombre de cliques en utilisant la somme d'argent choisie
            val nombreCliques = (sommeArgent *0.85).toInt()

            // Obtenir la carte correspondante en utilisant le nombre de cliques
            obtenirCarte(nombreCliques)
            // Afficher la carte obtenue
            //afficherCarte(carte)
        }
    }
}