package com.example.mobileapp_master.Data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Episode(

    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("air_date") var airDate : String? = null,
    @SerializedName("director") var director : String? = null,
    @SerializedName("writer") var writer : String? = null,
    @SerializedName("characters") var characters : ArrayList<String> = arrayListOf(),
    @SerializedName("img_url") var img_url : String
    ) : Parcelable