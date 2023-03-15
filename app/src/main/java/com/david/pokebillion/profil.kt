package com.david.pokebillion

object profil {
    var argent = 0
    var clickjour = 0
    var clicktotal = 0

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
}