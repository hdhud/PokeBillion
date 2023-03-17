package com.david.pokebillion

import android.content.Context
import java.io.*
import com.google.gson.Gson
class Carte (var id: Int, var nom: String, var Rarete: Int,var nb_carte: Int, var Trouver: Boolean, var nb_Total: Int):
    Serializable {

    override fun toString(): String {
        return "Carte(id=$id, nom='$nom', Rarete=$Rarete, nb_carte=$nb_carte, Trouver=$Trouver, nb_Total=$nb_Total)"
    }


    fun vendretous(){
        nb_carte = 0
        Trouver = false
    }
    fun vendretoussaufun(){
        nb_carte = 1
    }
    fun vendre(nb:Int) {
        nb_carte -= nb
    }

    companion object{

        fun getAllCartes(): List<Carte> {
            val carteList = mutableListOf<Carte>()
            val file = File("/data/user/0/com.david.pokebillion/files/Cartes.txt")
            if (file.exists()) {
                val fileInputStream = FileInputStream(file)
                val inputStream = ObjectInputStream(fileInputStream)
                val savedCartes = inputStream.readObject() as List<Carte>
                inputStream.close()
                carteList.addAll(savedCartes)
                println("Loading Cartes")
            }
            return carteList
        }

        fun saveData(carteList: List<Carte>) {
            val file = File("/data/user/0/com.david.pokebillion/files/Cartes.txt")
            val outputStream = ObjectOutputStream(FileOutputStream(file))
            outputStream.writeObject(carteList)
            outputStream.close()
            println("Saving Cartes")
        }
    }
}