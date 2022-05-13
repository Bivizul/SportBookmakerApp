package com.bivizul.sportbookmakerapp.data.mapper

import com.bivizul.sportbookmakerapp.data.network.model.TeamInfoJsonContainerDto
import com.bivizul.sportbookmakerapp.domain.models.TeamInfo
import com.google.gson.Gson

class TournamentMapper {

    fun mapJsonContainerToListTeamInfo(teamInfoJsonObject: TeamInfoJsonContainerDto): List<TeamInfo> {
        val result = mutableListOf<TeamInfo>()
        val jsonObject = teamInfoJsonObject.json
        // poluchaem kluchi 1,2,3...
        val teamKeySet = jsonObject.keySet()
        for (teamKey in teamKeySet) {
            // data team
            val currencyJson = jsonObject.getAsJsonObject(teamKey)
            val teamInfo = Gson().fromJson(
                currencyJson,
                TeamInfo::class.java
            )
            result.add(teamInfo)
        }
        return result
    }
}



