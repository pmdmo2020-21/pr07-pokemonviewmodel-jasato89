package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.MainActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity.SelectionActivity
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity.SelectionActivity.Companion.EXTRA_VIEW
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.databinding.ActivityMainBinding
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon
import java.lang.RuntimeException

private const val STATE_POKEMON1 = "STATE_POKEMON1"
private const val STATE_POKEMON2 = "STATE_POKEMON2"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private  val viewModel :MainViewModel by viewModels()
    private val selectionActivityCall = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {result ->
        val resultIntent = result.data
        if (result.resultCode==Activity.RESULT_OK && resultIntent != null) {
            extractResult(resultIntent)
                }
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()

    }



    private fun setupViews() {
        var pokemon1 :Pokemon = viewModel.pokemon1 as Pokemon
        var pokemon2 : Pokemon = viewModel.pokemon2 as Pokemon
        binding.lblBattlePokemon1.setText(pokemon1.name.toString())
        binding.lblBattlePokemon2.setText(pokemon2.name.toString())
        binding.pokemonImg1.setImageResource(pokemon1.image)
        binding.pokemonImage2.setImageResource(pokemon2.image)
        binding.pokemonView1.setOnClickListener { navigateToSelectionDetail(viewModel.pokemon1 as Pokemon, 1) }
        binding.pokemonView2.setOnClickListener { navigateToSelectionDetail(viewModel.pokemon2 as Pokemon, 2) }
        binding.mainViewBtn.setOnClickListener { navigateToWinnerActivity() }
    }

    private fun navigateToWinnerActivity() {
        TODO("Not yet implemented")
    }

    private fun navigateToSelectionDetail(pokemon: Pokemon, view: Int) {
        val intent = SelectionActivity.newIntent(this, pokemon, view)
        selectionActivityCall.launch(intent)


    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putParcelable(STATE_POKEMON1, viewModel.pokemon1 as Pokemon)
        outState.putParcelable(STATE_POKEMON2, viewModel. pokemon2 as Pokemon)
    }


    private fun extractResult(resultIntent: Intent) {
        if (!resultIntent.hasExtra(SelectionActivity.EXTRA_POKEMON) || !resultIntent.hasExtra(EXTRA_VIEW)) {
            throw RuntimeException()
        }
        else {
            if (resultIntent.getIntExtra(EXTRA_VIEW,0) == 1) {
                viewModel.definePokemon1(resultIntent.getParcelableExtra<Pokemon>(SelectionActivity.EXTRA_POKEMON)!!)

            }else if(resultIntent.getIntExtra(EXTRA_VIEW, 0) == 2) {
                viewModel.definePokemon2(resultIntent.getParcelableExtra<Pokemon>(SelectionActivity.EXTRA_POKEMON)!!)
            }
        }
    }





}


