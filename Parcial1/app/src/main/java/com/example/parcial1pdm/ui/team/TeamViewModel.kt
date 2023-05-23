package com.example.parcial1pdm.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial1pdm.TeamReviewerApplication
import com.example.parcial1pdm.data.model.TeamModel
import com.example.parcial1pdm.repositories.TeamRepository

class TeamViewModel(private val repository: TeamRepository): ViewModel() {

    fun getTeams() = repository.getTeams()
    fun addTeam(team: TeamModel) = repository.addTeam(team)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TeamReviewerApplication
                TeamViewModel(app.teamRepository)
            }
        }
    }

}