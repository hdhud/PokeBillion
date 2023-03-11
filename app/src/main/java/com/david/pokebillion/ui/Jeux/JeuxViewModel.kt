package com.david.pokebillion.ui.Jeux

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JeuxViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "C'est ici que tu pourra jouer à des jeux"
    }
    val text: LiveData<String> = _text
}