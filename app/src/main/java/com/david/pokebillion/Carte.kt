package com.david.pokebillion

import java.io.File
import java.io.FileOutputStream
import java.io.Serializable

class Carte (var id: Int, var nom: String, var Rarete: Int,var nb_carte: Int, var Trouver: Boolean, var nb_Total: Int):
    Serializable {

    override fun toString(): String {
        return "Carte(id=$id, nom='$nom', Rarete=$Rarete, nb_carte=$nb_carte, Trouver=$Trouver, nb_Total=$nb_Total)"
    }

    fun marquerTrouve() {
        Trouver = true
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
    fun ajouter(nb:Int) {
        nb_carte += nb
    }
    fun ajouter() {
        nb_carte += 1
    }


    


}