package com.david.pokebillion.ui.Clique

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CliqueViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "C'est ici que tu pourras cliquer pour collectionner des cartes"
    }
    val text: LiveData<String> = _text
}