package com.david.pokebillion

class Carte (var id: Int, var nom: String, var Rarete: String,var nb_carte: Int, var Trouver: Boolean){

    override fun toString(): String {
        return "Carte(id=$id, nom='$nom', Rarete='$Rarete', nb_crate=$nb_carte, Trouver=$Trouver)"
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

}