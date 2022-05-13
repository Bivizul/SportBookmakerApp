package com.bivizul.sportbookmakerapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.sportbookmakerapp.databinding.ItemStatisticBinding
import com.bivizul.sportbookmakerapp.domain.models.StatisticDefense
import com.bivizul.sportbookmakerapp.presentation.diffcallbacks.StatisticDefenseDiffCallback
import com.bivizul.sportbookmakerapp.presentation.viewholders.StatisticViewHolder

class StatisticDefenseAdapter() : ListAdapter<StatisticDefense, StatisticViewHolder>(
    StatisticDefenseDiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StatisticViewHolder {
        val binding = ItemStatisticBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StatisticViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatisticViewHolder, position: Int) {
        val statisticDefense = getItem(position)
        with(holder.binding) {
            with(statisticDefense) {
                tvStatistic1.text = team
                tvStatistic2.text = tournament
                tvStatistic3.text = strikes.toString()
                tvStatistic4.text = tackles.toString()
                tvStatistic5.text = interceptions.toString()
                tvStatistic6.text = fouls.toString()
                tvStatistic7.text = offsides.toString()
                tvStatistic8.text = rating.toString()
            }
        }
    }
}