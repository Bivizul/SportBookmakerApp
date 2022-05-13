package com.bivizul.sportbookmakerapp.data.network

import com.bivizul.sportbookmakerapp.data.network.ApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllNews() = apiService.getAllNews()
    suspend fun getAllStatisticDefense() = apiService.getAllStatisticDefense()
    suspend fun getAllStatisticAttack() = apiService.getAllStatisticAttack()
    suspend fun getAllTournamentTables() = apiService.getAllTournamentTables()

}