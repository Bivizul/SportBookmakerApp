package com.bivizul.sportbookmakerapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportbookmakerapp.data.network.ApiRepository
import com.bivizul.sportbookmakerapp.domain.models.StatisticAttack
import com.bivizul.sportbookmakerapp.utils.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticAttackViewModel @Inject constructor(private val repository: ApiRepository) :
    ViewModel() {

    private val _allStatisticAttack = MutableLiveData<List<StatisticAttack>>()
    val allStatisticAttack: LiveData<List<StatisticAttack>>
        get() = _allStatisticAttack

    fun getAllStatisticAttack() {
        viewModelScope.launch {
            repository.getAllStatisticAttack().let {
                if (it.isSuccessful) {
                    _allStatisticAttack.postValue(it.body())
                } else {
                    Log.d(TAG, "Failed to load statistic attack: ${it.errorBody()}")
                }
            }
        }
    }
}