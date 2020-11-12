package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89

import androidx.appcompat.app.AppCompatActivity
import android.app.Activity;
import android.os.Bundle
import android.renderscript.ScriptGroup
import es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}