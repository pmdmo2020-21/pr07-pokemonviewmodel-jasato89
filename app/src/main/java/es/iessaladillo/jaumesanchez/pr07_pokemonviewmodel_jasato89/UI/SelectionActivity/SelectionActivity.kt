package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.SelectionActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.viewModels
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.UI.MainActivity.MainActivity
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.databinding.ActivitySelectionBinding
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.Database
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model.Pokemon

class SelectionActivity : AppCompatActivity() {

    private val viewModel: SelectionViewModel by viewModels()
    private  val binding : ActivitySelectionBinding by lazy {
        ActivitySelectionBinding.inflate(layoutInflater)
    }

    companion object {

        const val EXTRA_POKEMON = "EXTRA_POKEMON"
        fun newIntent(context: Context, pokemon: Pokemon): Intent {
            return Intent(context, SelectionActivity::class.java).putExtra(EXTRA_POKEMON, pokemon)
        }
    }

    private lateinit var arrayRdb: Array<RadioButton>
    private lateinit var arrayImg : Array<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getDataFromMainActivity()
        setupFields()
        setupViews()
        observePokemon()
    }

    private fun observePokemon() {
        viewModel.pokemon.observe(this) {updatePokemon(it)}
    }

    private fun updatePokemon(it: Pokemon) {
        var pokemon : Pokemon
        for (rdb in arrayRdb) {
            pokemon = rdb.tag as Pokemon
            if (it != pokemon) {
                rdb.isChecked = false
            } else {
                if(!rdb.isChecked) {
                rdb.isChecked = true
                }
            }
        }

    }

    fun setupFields() {
        arrayRdb = arrayOf(
                binding.pikachuRdb,
                binding.giratinaRdb,
                binding.cuboneRdb,
                binding.bulbasurRdb,
                binding.feebasRdb,
                binding.gyaradosRdb,
        )
        arrayImg = arrayOf(
                binding.pikachuSelectorImg,
                binding.giratinaSelectorImg,
                binding.cuboneSelectorImg,
                binding.bulbasurSelectorImg,
                binding.feebasSelectorImg,
                binding.gyaradosSelectorImg
        )
    }

    private fun setupViews() {
        setupTags()
        setupListeners()
    }

    private fun setupListeners() {
        for (i in arrayRdb.indices) {
            arrayRdb[i].setOnClickListener { view: View -> checkRdb(view) }
        }
        for (i in arrayImg.indices) {
            arrayImg[i].setOnClickListener{view: View -> listenOnClickImage(view)}
        }
    }

    private fun listenOnClickImage(view: View) {
        val rdb: RadioButton = view.tag as RadioButton
        checkRdb(rdb)

    }

    private fun checkRdb(view: View) {
        val checkedRdb : RadioButton = view as RadioButton
        val pokemon: Pokemon =checkedRdb.tag as Pokemon
        viewModel.changePokemon(pokemon)
    }

    private fun setupTags() {
        for (i in arrayRdb.indices) {
            arrayRdb[i].tag = Database.getPokemonById(i.toLong())
        }

        for (i in arrayImg.indices) {
            arrayImg[i].tag = arrayRdb[i]
        }
    }

    private fun getDataFromMainActivity() {
        if (intent != null && intent.hasExtra(EXTRA_POKEMON)) {
            val pokemon: Pokemon? = intent.getParcelableExtra(EXTRA_POKEMON)
            if (pokemon != null) {
                viewModel.changePokemon(pokemon)
            }
        }
    }

    override fun onBackPressed() {
        setActivityResult()
        super.onBackPressed()
    }

    private fun setActivityResult() {
        val pokemon: Pokemon? = viewModel.pokemon.value
        if (pokemon != null) {
            val data: Intent = MainActivity.newIntent(this, pokemon)
            setResult(RESULT_OK, data)
        }
    }

}