package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.MainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.Database
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

const val STATE_POKEMON_ONE = "STATE POKEMON ONE"
const val STATE_POKEMON_TWO = "STATE POKEMON TWO"

class MainViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _pokemon1: MutableLiveData<Pokemon> = savedStateHandle.getLiveData(STATE_POKEMON_ONE, Database.getRandomPokemon())
    val pokemon1: LiveData<Pokemon>
        get() = _pokemon1
    private val _pokemon2: MutableLiveData<Pokemon> = savedStateHandle.getLiveData(STATE_POKEMON_TWO, Database.getRandomPokemon())
    val pokemon2: LiveData<Pokemon>
        get() = _pokemon2


    fun definePokemon1 (pokemon: Pokemon) {
        _pokemon1.value = pokemon
    }
    fun definePokemon2 (pokemon: Pokemon) {
        _pokemon2.value = pokemon
    }


}


