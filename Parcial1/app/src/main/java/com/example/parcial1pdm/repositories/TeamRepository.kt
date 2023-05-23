package com.example.parcial1pdm.repositories

import com.example.parcial1pdm.data.model.TeamModel

class TeamRepository(private val teams:MutableList<TeamModel> ) {

    fun getTeams() = teams

    fun addteam(newTeam: TeamModel) = teams.add(newTeam)
}