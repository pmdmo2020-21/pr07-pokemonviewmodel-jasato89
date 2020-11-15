package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.MainActivity.MainViewModel
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.databinding.ActivitySelectionBinding
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

class SelectionActivity : AppCompatActivity() {

    private val viewModel: SelectionViewModel by viewModels()
    private lateinit var binding : ActivitySelectionBinding
    private lateinit var pokemon1 : Pokemon
    private lateinit var pokemon2 : Pokemon


    companion object {

        const val EXTRA_POKEMON = "EXTRA_POKEMON"
        const val EXTRA_VIEW = "EXTRA_VIEW"

        fun newIntent(context: Context, pokemon: Pokemon, extraView : Int): Intent {

            return Intent(context, SelectionActivity::class.java)
                .putExtras(bundleOf(EXTRA_POKEMON to pokemon, EXTRA_VIEW to extraView))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)

        getContextData()
        setContentView(binding.root)
    }

    private fun getContextData() {
        viewModel.definePokemon1(intent.getParcelableExtra(EXTRA_POKEMON))

    }
}