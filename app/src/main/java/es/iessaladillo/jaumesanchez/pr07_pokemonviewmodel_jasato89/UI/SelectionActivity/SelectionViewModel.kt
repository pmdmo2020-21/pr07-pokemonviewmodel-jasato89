package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.Database
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

class SelectionViewModel : ViewModel() {

    private val _pokemon: MutableLiveData<Pokemon> = MutableLiveData(Database.getRandomPokemon())
    val pokemon: LiveData<Pokemon>
        get() = _pokemon


    fun changePokemon(pokemon: Pokemon) {
        _pokemon.value = pokemon


    }
}