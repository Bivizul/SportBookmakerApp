package com.bivizul.sportbookmakerapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_list")
data class TeamInfo(

    @PrimaryKey
    @SerializedName("Команда")
    @Expose
    val team: String?,

    @SerializedName("Игры")
    @Expose
    val games: Int?,

    @SerializedName("В")
    @Expose
    val v: Int?,

    @SerializedName("Н")
    @Expose
    val n: Int?,

    @SerializedName("П")
    @Expose
    val p: Int?,

    @SerializedName("Мячи")
    @Expose
    val bool: String?,

    @SerializedName("Очки")
    @Expose
    val specs: Int?,

    @SerializedName("% очков")
    @Expose
    val percent: String?

)