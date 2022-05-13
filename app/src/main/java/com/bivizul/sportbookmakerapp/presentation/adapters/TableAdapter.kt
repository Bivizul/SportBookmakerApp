package com.bivizul.sportbookmakerapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.sportbookmakerapp.databinding.ItemTableBinding
import com.bivizul.sportbookmakerapp.domain.models.TeamInfo
import com.bivizul.sportbookmakerapp.presentation.diffcallbacks.TablesDiffCallback
import com.bivizul.sportbookmakerapp.presentation.viewholders.TableViewHolder

class TableAdapter() : ListAdapter<TeamInfo, TableViewHolder>(TablesDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TableViewHolder {
        val binding = ItemTableBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val dataTeam = getItem(position)

        with(holder.binding)
        {
            with(dataTeam) {
                tvTable1.text = team
                tvTable2.text = games.toString()
                tvTable3.text = v.toString()
                tvTable4.text = n.toString()
                tvTable5.text = p.toString()
                tvTable6.text = bool
                tvTable7.text = specs.toString()
                tvTable8.text = percent
            }
        }
    }
}

