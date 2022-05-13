package com.bivizul.sportbookmakerapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportbookmakerapp.data.mapper.TournamentMapper
import com.bivizul.sportbookmakerapp.data.network.ApiRepository
import com.bivizul.sportbookmakerapp.domain.models.TeamInfo
import com.bivizul.sportbookmakerapp.utils.Constants.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TableViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    private val mapper = TournamentMapper()

    private val _allTable = MutableLiveData<List<TeamInfo>>()
    val allTable: LiveData<List<TeamInfo>>
        get() = _allTable

    fun getAllTable(country: Int) {
        viewModelScope.launch {
            repository.getAllTournamentTables().let {
                if (it.isSuccessful) {
                    val teamData = mapper.mapJsonContainerToListTeamInfo(it.body()!![country])
                    _allTable.postValue(teamData)
                } else {
                    Log.d(TAG, "Failed to load table: ${it.errorBody()}")
                }
            }
        }
    }


}