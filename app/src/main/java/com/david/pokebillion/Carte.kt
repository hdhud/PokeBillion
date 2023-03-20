package com.david.pokebillion

import android.content.Context
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
            //val file = File("data.txt")
            val file = File("/data/user/0/com.david.pokebillion/files/Cartes.txt")
            if (file.exists()) {
                val fileInputStream = FileInputStream(file)
                val inputStream = ObjectInputStream(fileInputStream)
                val savedCartes = inputStream.readObject() as List<Carte>
                inputStream.close()
                carteList.addAll(savedCartes)
                println("Loading Cartes")
            }else{
                file.createNewFile()
                val carteList = listOf<Carte>(
                    Carte(1, "Alakazam", 100000000, 1000, false, 0),
                    Carte(2, "Tortank", 1000000000, 0, false, 0),
                    Carte(3, "Leveinard", 100000000, 0, false, 0),
                    Carte(4, "Dracaufeu", 1000000000, 0, false, 0),
                    Carte(5, "Mélofée", 10000000, 0, false, 0),
                    Carte(6, "Léviator", 100000000, 0, false, 0),
                    Carte(7, "Tygnon", 10000000, 0, false, 0),
                    Carte(8, "Mackogneur", 100000000, 0, false, 0),
                    Carte(9, "Magneton", 10000000, 0, false, 0),
                    Carte(10, "Mewtwo", 100000000, 0, false, 0),
                    Carte(11, "Nidoking", 10000000, 0, false, 0),
                    Carte(12, "Feunard", 100000000, 0, false, 0),
                    Carte(13, "Tartard", 10000000, 0, false, 0),
                    Carte(14, "Raichu", 10000000, 0, false, 0),
                    Carte(15, "Florizarre", 1000000000, 0, false, 0),
                    Carte(16, "Électhor", 100000000, 0, false, 0),
                    Carte(17, "Dardargnan", 250000, 0, false, 0),
                    Carte(18, "Draco", 5000000, 0, false, 0),
                    Carte(19, "Triopikeur", 50000, 0, false, 0),
                    Carte(20, "Élektek", 1000000, 0, false, 0),
                    Carte(21, "Électrode", 75000, 0, false, 0),
                    Carte(22, "Roucoups", 500000, 0, false, 0),
                    Carte(23, "Arcanin", 500000, 0, false, 0),
                    Carte(24, "Reptincel", 5000000, 0, false, 0),
                    Carte(25, "Lamantine", 250000, 0, false, 0),
                    Carte(26, "Minidraco", 100000, 0, false, 0),
                    Carte(27, "Canarticho", 50000, 0, false, 0),
                    Carte(28, "Caninos", 75000, 0, false, 0),
                    Carte(29, "Spectrum", 500000, 0, false, 0),
                    Carte(30, "Herbizarre", 250000, 0, false, 0),
                    Carte(31, "Lippoutou", 25000, 0, false, 0),
                    Carte(32, "Kadabra", 1000000, 0, false, 0),
                    Carte(33, "Coconfort", 50000, 0, false, 0),
                    Carte(34, "Machopeur", 1000000, 0, false, 0),
                    Carte(35, "Magicarpe", 100000, 0, false, 0),
                    Carte(36, "Magmar", 500000, 0, false, 0),
                    Carte(37, "Nidorino", 1000000, 0, false, 0),
                    Carte(38, "Têtarte", 100000, 0, false, 0),
                    Carte(39, "Porygon", 25000, 0, false, 0),
                    Carte(40, "Rattatac", 50000, 0, false, 0),
                    Carte(41, "Otaria", 75000, 0, false, 0),
                    Carte(42, "Carabaffe", 5000000, 0, false, 0),
                    Carte(43, "Abra", 100000, 0, false, 0),
                    Carte(44, "Bulbizarre", 5000000, 0, false, 0),
                    Carte(45, "Chenipan", 10000, 0, false, 0),
                    Carte(46, "Salamèche", 250000, 0, false, 0),
                    Carte(47, "Taupiqueur", 10000, 0, false, 0),
                    Carte(48, "Doduo", 10000, 0, false, 0),
                    Carte(49, "Soporifik", 500000, 0, false, 0),
                    Carte(50, "Fantominus", 25000, 0, false, 0),
                    Carte(51, "Smogo", 100000, 0, false, 0),
                    Carte(52, "Machoc", 75000, 0, false, 0),
                    Carte(53, "Magneti", 50000, 0, false, 0),
                    Carte(54, "Chrysacier", 50000, 0, false, 0),
                    Carte(55, "Nidoran ♂", 100000, 0, false, 0),
                    Carte(56, "Onix", 1000000, 0, false, 0),
                    Carte(57, "Roucool", 25000, 0, false, 0),
                    Carte(58, "Pikachu", 5000000, 0, false, 0),
                    Carte(59, "Ptitard", 25000, 0, false, 0),
                    Carte(60, "Ponyta", 75000, 0, false, 0),
                    Carte(61, "Rattata", 10000, 0, false, 0),
                    Carte(62, "Sabelette", 500000, 0, false, 0),
                    Carte(63, "Carapuce", 250000, 0, false, 0),
                    Carte(64, "Staross", 250000, 0, false, 0),
                    Carte(65, "Stari", 25000, 0, false, 0),
                    Carte(66, "Saquedeneu", 10000, 0, false, 0),
                    Carte(67, "Voltorbe", 10000, 0, false, 0),
                    Carte(68, "Goupix", 1000000, 0, false, 0),
                    Carte(69, "Aspicot", 25000, 0, false, 0),
                    Carte(70, "Peluche Mélofée", 500, 0, false, 0),
                    Carte(71, "Recherche informatique", 500, 0, false, 0),
                    Carte(72, "Vaporisateur rétrograde", 500, 0, false, 0),
                    Carte(73, "Faux Professeur Chen", 500, 0, false, 0),
                    Carte(74, "Récupérateur", 500, 0, false, 0),
                    Carte(75, "Fillette", 500, 0, false, 0),
                    Carte(76, "Éleveur de Pokémon", 1000, 0, false, 0),
                    Carte(77, "Marchand de Pokémon", 1000, 0, false, 0),
                    Carte(78, "Rappel", 1000, 0, false, 0),
                    Carte(79, "Double Suppression d'Énergie", 1000, 0, false, 0),
                    Carte(80, "Defender", 1000, 0, false, 0),
                    Carte(81, "Sauvegarde d'Énergie", 1000, 0, false, 0),
                    Carte(82, "Guérison Totale", 2000, 0, false, 0),
                    Carte(83, "Entretien", 2000, 0, false, 0),
                    Carte(84, "PlusPower", 2000, 0, false, 0),
                    Carte(85, "Centre Pokémon", 2000, 0, false, 0),
                    Carte(86, "Flûte Pokémon", 2000, 0, false, 0),
                    Carte(87, "Pokédex", 2000, 0, false, 0),
                    Carte(88, "Professeur Chen", 2000, 0, false, 0),
                    Carte(89, "Réanimation", 5000, 0, false, 0),
                    Carte(90, "Super Potion", 5000, 0, false, 0),
                    Carte(91, "Léo", 5000, 0, false, 0),
                    Carte(92, "Suppression d'Énergie", 5000, 0, false, 0),
                    Carte(93, "Rafale de vent", 5000, 0, false, 0),
                    Carte(94, "Potion", 5000, 0, false, 0),
                    Carte(95, "Transfert", 5000, 0, false, 0),
                    Carte(96, "Double Énergie Incolore", 250, 0, false, 0),
                    Carte(97, "Énergie Combat", 250, 0, false, 0),
                    Carte(98, "Énergie Feu", 250, 0, false, 0),
                    Carte(99, "Énergie Plante", 250, 0, false, 0),
                    Carte(100, "Énergie Électrique", 250, 0, false, 0),
                    Carte(101, "Énergie Psy", 250, 0, false, 0),
                    Carte(102, "Énergie Eau", 250, 0, false, 0)
                )
                println("Createfile")
                saveData(carteList)
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