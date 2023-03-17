package com.david.pokebillion

import android.content.Context

object profil {

    var argent = 0
    var clickjour = 0
    var clicktotal = 0
    var carteList: List<Carte> = Carte.getAllCartes().toMutableList()

    fun addargent(nb: Int) {
        argent += nb
    }
    fun addclickjour(nb: Int) {
        clickjour += nb
    }
    fun addclicktotal(nb: Int) {
        clicktotal += nb
    }
    fun resetclickjour() {
        clickjour = 0
    }
    fun getargent(): Int {
        return argent
    }
    fun getclickjour(): Int {
        return clickjour
    }
    fun getclicktotal(): Int {
        return clicktotal
    }
    fun saveprofil() {
        Carte.saveData(carteList)
    }
    fun getcarteList(): List<Carte> {
        return carteList
    }
    //creer une fonction qui permet de modifier la liste de carte avec une carte en parametre
    fun setcarteList(carte: Carte) {
        carteList.listIterator().forEach {
            if (it.id == carte.id) {
                it.nb_carte = carte.nb_carte
                it.nb_Total = carte.nb_Total
                it.Trouver = carte.Trouver
            }
        }
    }
}