package com.bivizul.sportbookmakerapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bivizul.sportbookmakerapp.databinding.ItemNewsBinding
import com.bivizul.sportbookmakerapp.domain.models.News
import com.bivizul.sportbookmakerapp.presentation.diffcallbacks.NewsDiffCallback
import com.bivizul.sportbookmakerapp.presentation.viewholders.NewsViewHolder
import com.squareup.picasso.Picasso

class NewsAdapter() : ListAdapter<News, NewsViewHolder>(NewsDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        with(holder.binding) {
            with(news) {
                tvTittle.text = tittle
                tvText.text = text
                Picasso.get().load(img).into(imgNews)
                tvDate.text = date
            }
        }
    }
}