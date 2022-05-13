package com.bivizul.sportbookmakerapp.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import com.bivizul.sportbookmakerapp.domain.models.News

object NewsDiffCallback : DiffUtil.ItemCallback<News>() {

    // сравниваем, один и тот же объект?
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.tittle == newItem.tittle
    }

    // смотрим на изменение содержимого
    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}