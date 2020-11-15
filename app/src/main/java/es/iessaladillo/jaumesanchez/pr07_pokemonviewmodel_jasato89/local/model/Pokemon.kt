package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(val id:Long, val name: Int, val image: Int, val strength: Int) : Parcelable {

}

