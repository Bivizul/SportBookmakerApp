package com.bivizul.sportbookmakerapp.data.network

import com.bivizul.sportbookmakerapp.data.network.model.TeamInfoJsonContainerDto
import com.bivizul.sportbookmakerapp.domain.models.News
import com.bivizul.sportbookmakerapp.domain.models.StatisticAttack
import com.bivizul.sportbookmakerapp.domain.models.StatisticDefense
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/api/data_tournament_tables.json")
    suspend fun getAllTournamentTables(): Response<List<TeamInfoJsonContainerDto>>

    @GET("/api/news.json")
    suspend fun getAllNews(): Response<List<News>>

    @GET("/api/data_statistic_defense.json")
    suspend fun getAllStatisticDefense(): Response<List<StatisticDefense>>

    @GET("/api/data_statistic_attack.json")
    suspend fun getAllStatisticAttack(): Response<List<StatisticAttack>>
}