package com.bivizul.sportbookmakerapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportbookmakerapp.data.network.ApiRepository
import com.bivizul.sportbookmakerapp.domain.models.News
import com.bivizul.sportbookmakerapp.utils.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val _allNews = MutableLiveData<List<News>>()
    val allNews: LiveData<List<News>>
        get() = _allNews

    fun getAllNews() {
        viewModelScope.launch {
            repository.getAllNews().let {
                if (it.isSuccessful) {
                    _allNews.postValue(it.body())
                } else {
                    Log.d(TAG, "Failed to load news: ${it.errorBody()}")
                }
            }
        }
    }
}