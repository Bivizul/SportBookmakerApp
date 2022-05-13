package com.bivizul.sportbookmakerapp.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.sportbookmakerapp.domain.models.StatisticAttack

object StatisticAttackDiffCallback : DiffUtil.ItemCallback<StatisticAttack>() {

    // сравниваем, один и тот же объект?
    override fun areItemsTheSame(oldItem: StatisticAttack, newItem: StatisticAttack): Boolean {
        return oldItem.team == newItem.team
    }

    // смотрим на изменение содержимого
    override fun areContentsTheSame(oldItem: StatisticAttack, newItem: StatisticAttack): Boolean {
        return oldItem == newItem
    }
}