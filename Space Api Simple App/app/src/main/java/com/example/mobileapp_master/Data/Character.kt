package com.example.mobileapp_master.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val abilities: List<String>?,
    val alias: List<String>?,
    val gender: String?,
    val hair: String?,
    val id: Int?,
    val img_url: String?,
    val name: String?,
    val origin: String?,
    val species: String?,
    val status: String?
) : Parcelable