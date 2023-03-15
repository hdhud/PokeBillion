package com.david.pokebillion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import com.david.pokebillion.ui.MesCartes.CartesFragment

class Vendre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendre)
        val carte = intent.getSerializableExtra("carte") as Carte
        val vendre = findViewById<SeekBar>(R.id.seekBarvendre)
        val valider = findViewById<Button>(R.id.Valider)
        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        editTextNumber.setText((carte.nb_carte-1).toString())
        editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable) {
                if (editTextNumber.text.toString() != "") {

                    if (editTextNumber.text.toString().toInt() > carte.nb_carte) {
                        editTextNumber.setText(carte.nb_carte.toString())
                    }
                    vendre.progress = editTextNumber.text.toString().toInt()
                }
            }
        })
        vendre.max = carte.nb_carte
        vendre.progress = carte.nb_carte-1
        vendre.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                System.out.println(progress)
                editTextNumber.setText(progress.toString())
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        valider.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Vendre")
                .setMessage("Voulez-vous vraiment vendre ${vendre.progress} ${carte.nom} pour ${vendre.progress*carte.Rarete} pièce?")
                .setPositiveButton("Oui") { dialog, which ->
                    carte.nb_carte = carte.nb_carte - vendre.progress
                    val intent = Intent(this, MainActivity::class.java)
                    profil.argent = profil.argent + (vendre.progress*carte.Rarete)
                    println(profil.argent)
                    profil.setcarteList(carte)
                    startActivity(intent)
                }
                .setNegativeButton("Non") { dialog, which ->
                    val intent = Intent(this, CarteActivity::class.java)
                    intent.putExtra("carte", carte)
                    startActivity(intent)
                }
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
        }
    }
}