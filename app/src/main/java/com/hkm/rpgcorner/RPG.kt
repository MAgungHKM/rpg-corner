package com.hkm.rpgcorner

import android.os.Parcel
import android.os.Parcelable

data class RPG(
    var name: String? = "",
    var detail: String? = "",
    var price: String? = "",
    var link: String? = "",
    var review: String? = "",
    var photo: Int = 0,
    var store: Int = 0,
    var game: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(detail)
        parcel.writeString(price)
        parcel.writeString(link)
        parcel.writeString(review)
        parcel.writeInt(photo)
        parcel.writeInt(store)
        parcel.writeInt(game)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RPG> {
        override fun createFromParcel(parcel: Parcel): RPG {
            return RPG(parcel)
        }

        override fun newArray(size: Int): Array<RPG?> {
            return arrayOfNulls(size)
        }
    }

}