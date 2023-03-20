package com.david.pokebillion

import java.io.*
import com.google.gson.Gson
class Carte (var id: Int, var nom: String, var Rarete: Int,var nb_carte: Int, var Trouver: Boolean, var nb_Total: Int):
    Serializable {
    @JvmName("getRarete1")
    fun getRarete():Int{
        return this.Rarete
    }

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
            val file = File("data.txt")
            if (file.exists()) {
                val fileInputStream = FileInputStream(file)
                val inputStream = ObjectInputStream(fileInputStream)
                val savedCartes = inputStream.readObject() as List<Carte>
                inputStream.close()
                carteList.addAll(savedCartes)
                println("Loading")
            }
            return carteList
        }

        fun saveData(carteList: List<Carte>) {
            val file = File("/data/user/0/com.david.pokebillion/files/data.txt")
            val outputStream = ObjectOutputStream(FileOutputStream(file))
            outputStream.writeObject(carteList)
            outputStream.close()
            println("Saving")
        }
        fun chargerCartes(): List<Carte> {
            val gson = Gson()
            val fichier = File("carte.json")
            val contenu = fichier.readText()
            println(contenu)
            return gson.fromJson(contenu, Array<Carte>::class.java).toList()
        }

        // Fonction pour enregistrer les cartes dans un fichier
        fun sauvegarderCartes(cartes: List<Carte>) {
            val gson = Gson()
            val fichier = File("/src/main/java/com.david.pokebillion/Carte.json")
            val contenu = gson.toJson(cartes)
            println(contenu)
            fichier.writeText(contenu)
        }
    }
}