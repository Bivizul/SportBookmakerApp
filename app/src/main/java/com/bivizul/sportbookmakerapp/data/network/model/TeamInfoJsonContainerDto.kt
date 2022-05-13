package com.bivizul.sportbookmakerapp.data.network.model

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TeamInfoJsonContainerDto(

    @SerializedName("data")
    @Expose
    val json: JsonObject

)
