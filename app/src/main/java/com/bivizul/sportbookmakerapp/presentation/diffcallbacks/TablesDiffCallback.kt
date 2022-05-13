package com.bivizul.sportbookmakerapp.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.sportbookmakerapp.domain.models.TeamInfo

object TablesDiffCallback : DiffUtil.ItemCallback<TeamInfo>() {

    // сравниваем, один и тот же объект?
    override fun areItemsTheSame(oldCountry: TeamInfo, newCountry: TeamInfo): Boolean {
        return oldCountry.team == newCountry.team
    }

    // смотрим на изменение содержимого
    override fun areContentsTheSame(oldCountry: TeamInfo, newCountry: TeamInfo): Boolean {
        return oldCountry == newCountry
    }
}