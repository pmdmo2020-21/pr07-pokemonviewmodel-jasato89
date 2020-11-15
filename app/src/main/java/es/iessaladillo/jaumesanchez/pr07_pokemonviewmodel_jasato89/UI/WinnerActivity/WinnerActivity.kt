package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.WinnerActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.R
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity.SelectionActivity
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

class WinnerActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_POKEMON = "EXTRA_POKEMON"


        fun newIntent(context: Context, pokemon: Pokemon): Intent {

            return Intent(context, WinnerActivity::class.java).putExtra(EXTRA_POKEMON, pokemon)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
    }
}