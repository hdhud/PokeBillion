package com.david.pokebillion

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.concurrent.Executors

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
            if (carte.nb_carte > 0) {
                val intent = Intent(this, Vendre::class.java)

                intent.putExtra("carte", carte)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Vous ne possédez pas cette carte", Toast.LENGTH_SHORT).show()
            }

        }
        val imagepokemon = findViewById<ImageView>(R.id.imageView2)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image:Bitmap? = null
        executor.execute {
            try {
                image = Carte.imagepokemon(carte)
                handler.post {
                    imagepokemon.setImageBitmap(image)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }
}