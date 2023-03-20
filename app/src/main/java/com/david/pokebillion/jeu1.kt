package com.david.pokebillion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import com.david.pokebillion.profil.carteList
import com.david.pokebillion.profil.setcarteList
import java.lang.Integer.parseInt

class jeu1 : AppCompatActivity() {
    // Fonction pour obtenir une carte en utilisant le nombre de cliques
    fun obtenirCarte(nombredeclique:Int):Int {

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
        return maxrarete
    }

    fun randomCard(maxrarete: Int): Carte{
        var compteur = 0
        var finalCard = Carte(0, "Mew", 1, 0, false,0)
        for (i in carteList){
            if (maxrarete == i.getRarete())
                compteur += 1
        }
        val carte_aleatoire = randomINT(1,compteur)
        compteur =0
        for (i in carteList){
            if (maxrarete == i.getRarete()){
                compteur +=1
                if (compteur == carte_aleatoire) {
                    finalCard = i
                }
            }
        }
        return finalCard
    }
    fun randomINT(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1) + min).toInt()
    }

    // Fonction pour afficher la carte obtenue
    fun afficherCarte(carte: Carte) {
        // renvoie la carte obtenue

        Toast.makeText(this, carte.nom + ", rareté: " + carte.Rarete, Toast.LENGTH_SHORT).show()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu1)

        var clickable = false
        val image_egg = findViewById<ImageView>(R.id.imageView)
        val carteFinal :Carte






        // Récupérer l'argent disponible dans le singleton Profil
        val argentDisponible = profil.argent

        // Créer un curseur (slider) avec une plage de valeurs entre 0 et l'argent disponible
        val curseurArgent = findViewById<SeekBar>(R.id.curseur_argent)
        val curseurvaleur = findViewById<EditText>(R.id.editTextNumber)
        // Définir la plage de valeurs du curseur

        if (argentDisponible > 500000)
            curseurArgent.max = 500000
        else
            curseurArgent.max = argentDisponible
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
            profil.argent -= sommeArgent

            // Simuler le nombre de cliques en utilisant la somme d'argent choisie
            val nombreCliques = (sommeArgent *0.75).toInt()

            // Obtenir la carte correspondante en utilisant le nombre de cliques
            var rarete = obtenirCarte(nombreCliques)
            val carteFinal = randomCard(rarete)
            // Afficher la carte obtenue
            if (carteFinal.nom == "Mew") {
                Toast.makeText(
                    this,
                    "Vous n'avez pas obtenu de carte, vous recevez donc la moitié de votre argent.",
                    Toast.LENGTH_SHORT
                ).show()
                profil.argent += sommeArgent / 2
            }
            else{
                clickable = true
                image_egg.setImageResource(R.drawable.egg)
                Toast.makeText(this, "Cliquez sur l'oeuf.", Toast.LENGTH_SHORT).show()
            }
            image_egg.setOnClickListener()
            {
                if (clickable == true) {
                    image_egg.setImageResource(R.drawable.img)
                    afficherCarte(carteFinal)
                    setcarteList(carteFinal)
                    clickable = false
                }
            }
        }
    }

}