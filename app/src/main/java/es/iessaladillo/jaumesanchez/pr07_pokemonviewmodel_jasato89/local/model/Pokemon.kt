package es.iessaladillo.jaumesanchez.pr07_pokemonviewmodel_jasato89.local.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(val id:Long, val name: Int, val image: Int, val strength: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    //override fun describeContents() = 0

    companion object : Parceler<Pokemon> {

        override fun Pokemon.write(parcel: Parcel, flags: Int) {
            parcel.writeLong(id)
            parcel.writeInt(name)
            parcel.writeInt(image)
            parcel.writeInt(strength)
        }

        override fun create(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

    }
}

