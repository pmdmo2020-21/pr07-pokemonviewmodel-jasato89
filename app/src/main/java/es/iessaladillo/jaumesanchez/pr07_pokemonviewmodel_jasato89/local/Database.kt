package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local

import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.R
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon
import java.lang.NullPointerException

import kotlin.random.Random.Default.nextInt

// TODO: Haz que Database implemente DataSource
object Database : DataSource {

    private val pikachu: Pokemon = Pokemon(0, R.string.pikachu, R.drawable.pikachu, 180)
    private val giratina:Pokemon = Pokemon(1, R.string.giratina, R.drawable.giratina, 80)
    private val cubone:Pokemon = Pokemon(2, R.string.cubone, R.drawable.cubone, 125)
    private val bulbasur:Pokemon = Pokemon(3, R.string.bulbasur, R.drawable.bulbasur, 175)
    private val feebas: Pokemon = Pokemon(4, R.string.feebas, R.drawable.feebas, 99)
    private val gyarados: Pokemon = Pokemon(5, R.string.gyarados, R.drawable.gyarados, 87)
    private val pokemonList: List<Pokemon> = listOf(pikachu, giratina, cubone, bulbasur, feebas, gyarados)


    override fun getRandomPokemon(): Pokemon {
        return pokemonList[nextInt(6)]
    }


    override fun getAllPokemons(): List<Pokemon> {
        return pokemonList
    }

    override fun getPokemonById(id: Long): Pokemon {
        for (pokemon in pokemonList) {
            if (pokemon.id.toLong()== id){
                return pokemon
            }
        }
        throw NullPointerException()
    }

}