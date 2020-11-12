package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local

import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

// IMPORTANTE: NO TOCAR
interface DataSource {
    fun getRandomPokemon(): Pokemon
    fun getAllPokemons(): List<Pokemon>
    fun getPokemonById(id: Long): Pokemon?
}