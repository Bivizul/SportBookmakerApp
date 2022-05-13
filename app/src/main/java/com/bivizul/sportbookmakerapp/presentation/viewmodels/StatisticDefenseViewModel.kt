package com.bivizul.sportbookmakerapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportbookmakerapp.data.network.ApiRepository
import com.bivizul.sportbookmakerapp.domain.models.StatisticDefense
import com.bivizul.sportbookmakerapp.utils.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticDefenseViewModel @Inject constructor(private val repository: ApiRepository) :
    ViewModel() {

    private val _allStatisticDefense = MutableLiveData<List<StatisticDefense>>()
    val allStatisticDefense: LiveData<List<StatisticDefense>>
        get() = _allStatisticDefense

    fun getAllStatisticDefense() {
        viewModelScope.launch {
            repository.getAllStatisticDefense().let {
                if (it.isSuccessful) {
                    _allStatisticDefense.postValue(it.body())
                } else {
                    Log.d(TAG, "Failed to load statistic defense: ${it.errorBody()}")
                }
            }
        }
    }
}