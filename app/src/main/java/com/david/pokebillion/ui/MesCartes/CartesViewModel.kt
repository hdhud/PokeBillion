package com.david.pokebillion.ui.MesCartes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CartesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "C'est ici que tu peux voir les cartes que tu as obtenu"
    }
    val text: LiveData<String> = _text
}