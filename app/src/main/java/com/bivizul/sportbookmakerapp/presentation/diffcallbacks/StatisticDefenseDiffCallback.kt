package com.bivizul.sportbookmakerapp.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.sportbookmakerapp.domain.models.StatisticDefense

object StatisticDefenseDiffCallback : DiffUtil.ItemCallback<StatisticDefense>() {

    // сравниваем, один и тот же объект?
    override fun areItemsTheSame(oldItem: StatisticDefense, newItem: StatisticDefense): Boolean {
        return oldItem.team == newItem.team
    }

    // смотрим на изменение содержимого
    override fun areContentsTheSame(oldItem: StatisticDefense, newItem: StatisticDefense): Boolean {
        return oldItem == newItem
    }
}