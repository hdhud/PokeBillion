package com.david.pokebillion

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.david.pokebillion.profil.carteList
import com.david.pokebillion.profil.setcarteList
import java.lang.Integer.parseInt
import java.util.concurrent.Executors

class jeu2 : AppCompatActivity() {
    // Fonction pour obtenir une carte en utilisant le nombre de cliques

    var nombreImageClique=0
    var valider = false
    var validerImage1 = true
    var validerImage2 = true
    var validerImage3 = true
    var validerImage4 = true
    var validerImage5 = true
    var validerImage6 = true
    var validerImage7 = true
    var validerImage8 = true
    var validerImage9 = true
    var tab_cartes = mutableListOf<Carte>()
    var tab_cartes_Gagne = mutableListOf<Carte>()
    fun obtenirCarte(nombreDeClique: Int): List<Int> {
        val meilleursModulos = mutableListOf<Int>()
        val modulos = listOf(
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
        val compteurDeModulos = mutableMapOf<Int, Int>()

        for (i in 0..nombreDeClique) {
            val random = randomINT(0, 1000000000)
            for (j in modulos) {
                if (random % (j / 1000) == 0) {
                    if (compteurDeModulos.containsKey(j)) {
                        compteurDeModulos[j] = compteurDeModulos[j]!! + 1
                    } else {
                        compteurDeModulos[j] = 1
                    }
                }
            }
        }

        val modulosTries = compteurDeModulos.toList().sortedBy { (_, value) -> value }.toMap()
        var index = 0
        for ((key, nb) in modulosTries) {
            if (nb==1){
                meilleursModulos.add(key)
                index++
            }
            if (nb>=2){
                val nombre = randomINT(2,3)
                if (meilleursModulos.size + 2 <=9)
                    for (i in 1..nombre){
                        meilleursModulos.add(key)
                        index ++
                    }
                else if(meilleursModulos.size + 2>9 && meilleursModulos.size +1<=9)
                    meilleursModulos.add(key)
                index ++

            }
        }

        return meilleursModulos
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu2)
        val img1 = findViewById<ImageView>(R.id.img1)
        val img2 = findViewById<ImageView>(R.id.img2)
        val img3 = findViewById<ImageView>(R.id.img3)
        val img4 = findViewById<ImageView>(R.id.img4)
        val img5 = findViewById<ImageView>(R.id.img5)
        val img6 = findViewById<ImageView>(R.id.img6)
        val img7 = findViewById<ImageView>(R.id.img7)
        val img8 = findViewById<ImageView>(R.id.img8)
        val img9 = findViewById<ImageView>(R.id.img9)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        img1.setOnClickListener(){
            if (valider){
                if (validerImage1){


                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[0])
                            handler.post {
                                img1.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage1 = false
                    nombreImageClique++
                    tab_cartes_Gagne.add(tab_cartes[0])
                setcarteList(tab_cartes[0])
                    if (nombreImageClique==3) {
                        finjeu2()
                    }
                }
            }
        }
        img2.setOnClickListener(){
            if (valider){
                if (validerImage2){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[1])
                            handler.post {
                                img2.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage2 = false
                    nombreImageClique++
                    tab_cartes_Gagne.add(tab_cartes[1])
                setcarteList(tab_cartes[1])
                    if (nombreImageClique==3) {
                        finjeu2()
                    }
                }
            }
        }
        img3.setOnClickListener(){
            if (valider){
                if (validerImage3){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[2])
                            handler.post {
                                img3.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage3 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[2])
                if (nombreImageClique==3) {
                    finjeu2()
                    }
                }
            }
        }
        img4.setOnClickListener(){
            if (valider){
                if (validerImage4){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[3])
                            handler.post {
                                img4.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage4 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[3])
                setcarteList(tab_cartes[3])
                if (nombreImageClique==3) {
                    finjeu2()
                    }
                }
            }
        }
        img5.setOnClickListener(){
            if (valider){
                if (validerImage5){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[4])
                            handler.post {
                                img5.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage5 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[4])
                setcarteList(tab_cartes[4])
                if (nombreImageClique==3) {
                    finjeu2()
                    }
                }
            }
        }
        img6.setOnClickListener(){
            if (valider){
                if (validerImage6){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[5])
                            handler.post {
                                img6.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage6 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[5])
                setcarteList(tab_cartes[5])
                if (nombreImageClique==3) {
                    finjeu2()
                }}}

        }
        img7.setOnClickListener(){
            if (valider){
                if (validerImage7) {

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[6])
                            handler.post {
                                img7.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage7 = false
                    nombreImageClique++
                    tab_cartes_Gagne.add(tab_cartes[6])
                    setcarteList(tab_cartes[6])
                    if (nombreImageClique == 3) {
                        finjeu2()
                    }
                }
            }
        }
        img8.setOnClickListener(){
            if (valider){
                if (validerImage8){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[7])
                            handler.post {
                                img8.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage8 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[7])
                setcarteList(tab_cartes[7])
                if (nombreImageClique==3) {
                    finjeu2()
                    }
                }
            }
        }
        img9.setOnClickListener(){
            if (valider){
                if (validerImage9){

                    executor.execute {
                        try {
                            image = Carte.imagepokemon(tab_cartes[8])
                            handler.post {
                                img9.setImageBitmap(image)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    validerImage9 = false
                nombreImageClique++
                tab_cartes_Gagne.add(tab_cartes[8])
                setcarteList(tab_cartes[8])
                if (nombreImageClique==3) {
                    finjeu2()
                    }
                }
            }
        }




        // Récupérer l'argent disponible dans le singleton Profil
        val argentDisponible = profil.argent

        // Créer un curseur (slider) avec une plage de valeurs entre 0 et l'argent disponible
        val curseurArgent = findViewById<SeekBar>(R.id.curseur_argent)
        val curseurvaleur = findViewById<EditText>(R.id.editTextNumber)
        // Définir la plage de valeurs du curseur
        curseurArgent.min = 500000
        if (argentDisponible > 300000000)
            curseurArgent.max = 300000000
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
            validerImage1 = true
            validerImage2 = true
            validerImage3 = true
            validerImage4 = true
            validerImage5 = true
            validerImage6 = true
            validerImage7 = true
            validerImage8 = true
            validerImage9 = true
            nombreImageClique = 0
            valider = true
            tab_cartes.clear()
            tab_cartes_Gagne.clear()
            img1.setImageResource(R.drawable.img)
            img2.setImageResource(R.drawable.img)
            img3.setImageResource(R.drawable.img)
            img4.setImageResource(R.drawable.img)
            img5.setImageResource(R.drawable.img)
            img6.setImageResource(R.drawable.img)
            img7.setImageResource(R.drawable.img)
            img8.setImageResource(R.drawable.img)
            img9.setImageResource(R.drawable.img)
            Toast.makeText(this, "Choisissez 3 cartes.", Toast.LENGTH_SHORT).show()

            // Récupérer la somme d'argent choisie par l'utilisateur à partir du curseur
            val sommeArgent = curseurArgent.progress

            // Simuler le nombre de cliques en utilisant la somme d'argent choisie
            val nombreCliques = (sommeArgent/1000).toInt()

            // Obtenir la carte correspondante en utilisant le nombre de cliques
            var tab_rarete = obtenirCarte(nombreCliques)
            //renvoie rarete

            for (i in tab_rarete){
                var ca = randomCard(i)
                tab_cartes.add(ca)
            }
            profil.argent -= sommeArgent
            val sharedPreferences: SharedPreferences = getSharedPreferences("profil", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putInt("argent", profil.argent)
            editor.apply()

        }

    }

    fun finjeu2() {
            valider = false
            tab_cartes_Gagne[0].nb_carte++
            tab_cartes_Gagne[0].nb_Total++
            tab_cartes_Gagne[2].nb_carte++
            tab_cartes_Gagne[2].nb_Total++
            tab_cartes_Gagne[1].nb_carte++
            tab_cartes_Gagne[1].nb_Total++
            //Toast.makeText(this, "Vous avez gagné les cartes: " + tab_cartes_Gagne[0].nom + ", " + tab_cartes_Gagne[1].nom + ", " + tab_cartes_Gagne[2].nom, Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Félicitations!")
            builder.setMessage("Vous avez gagné les cartes: \n" + tab_cartes_Gagne[0].nom +" "+tab_cartes_Gagne[0].Rarete +", \n" + tab_cartes_Gagne[1].nom +" "+tab_cartes_Gagne[1].Rarete + ", \n" + tab_cartes_Gagne[2].nom+" "+tab_cartes_Gagne[2].Rarete )

            builder.show()

    }
}