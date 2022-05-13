package com.bivizul.sportbookmakerapp.domain.models

import com.google.gson.annotations.SerializedName

data class StatisticDefense(
    @SerializedName("Команда")
    val team: String,

    @SerializedName("Турнир")
    val tournament: String,

    @SerializedName("Удары з.и.")
    val strikes: Double,

    @SerializedName("Отборы  з.и.")
    val tackles: Double,

    @SerializedName("Перехваты з.и.")
    val interceptions: Double,

    @SerializedName("Фолы з.и.")
    val fouls: Double,

    @SerializedName("Офсайды з.и.")
    val offsides: Double,

    @SerializedName("Рейтинг")
    val rating: Double
)
