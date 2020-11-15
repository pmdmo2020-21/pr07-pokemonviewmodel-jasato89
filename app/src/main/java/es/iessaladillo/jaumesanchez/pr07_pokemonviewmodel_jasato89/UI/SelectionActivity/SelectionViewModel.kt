package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.Database
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

class SelectionViewModel : ViewModel() {

    private val _pokemon1: MutableLiveData<Pokemon> = MutableLiveData(Database.getRandomPokemon())
    val pokemon1: LiveData<Pokemon>
        get() = _pokemon1
    private val _pokemon2: MutableLiveData<Pokemon> = MutableLiveData(Database.getRandomPokemon(pokemon1 as Pokemon))
    val pokemon2: LiveData<Pokemon>
        get() = _pokemon2


    fun definePokemon1 (pokemon: Pokemon) {
        _pokemon1.value = pokemon
    }
    fun definePokemon2 (pokemon: Pokemon?) {
        _pokemon2.value = pokemon
    }
}