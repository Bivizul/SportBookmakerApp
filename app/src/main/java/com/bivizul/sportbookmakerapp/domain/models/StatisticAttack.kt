package com.bivizul.sportbookmakerapp.domain.models

import com.google.gson.annotations.SerializedName

data class StatisticAttack(
    @SerializedName("Команда")
    val team: String,

    @SerializedName("Турнир")
    val tournament: String,

    @SerializedName("Удары з.и.")
    val strikes: Double,

    @SerializedName("Удары ВСтв з.и.")
    val strikesVs: Double,

    @SerializedName("Дриблинг з.и.")
    val dribbling: Double,

    @SerializedName("Дано фолов з.и.")
    val givenFouls: Double,

    @SerializedName("Рейтинг")
    val rating: Double
)