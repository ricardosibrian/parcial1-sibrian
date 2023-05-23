package com.example.parcial1pdm

import android.app.Application
import com.example.parcial1pdm.data.teams
import com.example.parcial1pdm.repositories.TeamRepository

class TeamReviewerApplication: Application() {
    val teamRepository: TeamRepository by lazy {
        TeamRepository(teams)
    }
}