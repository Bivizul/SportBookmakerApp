package com.bivizul.sportbookmakerapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.sportbookmakerapp.databinding.ItemStatisticBinding
import com.bivizul.sportbookmakerapp.domain.models.StatisticAttack
import com.bivizul.sportbookmakerapp.presentation.diffcallbacks.StatisticAttackDiffCallback
import com.bivizul.sportbookmakerapp.presentation.viewholders.StatisticViewHolder

class StatisticAttackAdapter() : ListAdapter<StatisticAttack, StatisticViewHolder>(
    StatisticAttackDiffCallback
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
        val statisticAttack = getItem(position)
        with(holder.binding) {
            with(statisticAttack) {
                tvStatistic1.text = team
                tvStatistic2.text = tournament
                tvStatistic3.text = strikes.toString()
                tvStatistic4.text = strikesVs.toString()
                tvStatistic5.text = dribbling.toString()
                tvStatistic6.text = givenFouls.toString()
                tvStatistic7.text = rating.toString()
                tvStatistic8.text = ""
            }
        }
    }

}