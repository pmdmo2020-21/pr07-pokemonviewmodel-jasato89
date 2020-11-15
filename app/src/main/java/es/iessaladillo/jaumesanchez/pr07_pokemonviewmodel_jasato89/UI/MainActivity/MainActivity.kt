package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.MainActivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity.SelectionActivity
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.databinding.ActivityMainBinding
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon


class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_POKEMON = "EXTRA_POKEMON"
        fun newIntent(context: Context, pokemon: Pokemon): Intent {
            return Intent(context, MainActivity::class.java).putExtra(EXTRA_POKEMON, pokemon)
        }
    }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by viewModels()

    private val selectionActivityCallPokemon1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        val resultIntent = result.data
        if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
            val pokemon: Pokemon? = result.data?.getParcelableExtra(EXTRA_POKEMON)
            if (pokemon != null) {
                viewModel.definePokemon1(pokemon)
            }
        }
    }

    private val selectionActivityCallPokemon2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        val resultIntent = result.data
        if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
            val pokemon: Pokemon? = result.data?.getParcelableExtra(EXTRA_POKEMON)
            if (pokemon != null) {
                viewModel.definePokemon2(pokemon)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
        observeData()

    }

    private fun observeData() {
        viewModel.pokemon1.observe(this) { showPokemon1(it) }
        viewModel.pokemon2.observe(this) { showPokemon2(it) }
    }

    private fun showPokemon2(it: Pokemon) {
        binding.pokemonImage2.setImageResource(it.image)
        binding.lblBattlePokemon2.setText(it.name)
    }

    private fun showPokemon1(it: Pokemon) {
        binding.pokemonImg1.setImageResource(it.image)
        binding.lblBattlePokemon1.setText(it.name)

    }


    private fun setupViews() {

        binding.pokemonView1.setOnClickListener { navigateToSelectionDetail(selectionActivityCallPokemon1, viewModel.pokemon1) }
        binding.pokemonView2.setOnClickListener { navigateToSelectionDetail(selectionActivityCallPokemon2, viewModel.pokemon2) }
        binding.mainViewBtn.setOnClickListener { navigateToWinnerActivity() }


    }

    private fun navigateToWinnerActivity() {
        TODO("Not yet implemented")
    }

    private fun navigateToSelectionDetail(selectionActivityCall: ActivityResultLauncher<Intent>, inputPokemon: LiveData<Pokemon>) {
        val pokemon: Pokemon = inputPokemon.value
                ?: throw NullPointerException("A pokemon must be returned")
        val data: Intent = SelectionActivity.newIntent(this, pokemon)
        selectionActivityCall.launch(data)

    }

}


