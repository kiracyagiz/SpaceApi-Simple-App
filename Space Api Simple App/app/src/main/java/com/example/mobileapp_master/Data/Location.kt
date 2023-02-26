package com.example.mobileapp_master.Data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val id: Int?,
    val img_url: String?,
    val inhabitants: List<String>?,
    val name: String?,
    val notableResidents: List<String>?,
    val type: String?
) : Parcelable