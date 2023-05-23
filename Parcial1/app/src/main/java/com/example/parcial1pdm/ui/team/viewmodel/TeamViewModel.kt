package com.example.parcial1pdm.ui.team.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.parcial1pdm.TeamReviewerApplication
import com.example.parcial1pdm.data.model.TeamModel
import com.example.parcial1pdm.repositories.TeamRepository

class TeamViewModel(private val repository: TeamRepository): ViewModel() {

    // Aqui se implementa LiveData
    var name = MutableLiveData("")
    var sport = MutableLiveData("")
    var status = MutableLiveData("")

    fun getTeams() = repository.getTeams()
    fun addTeam(team: TeamModel) = repository.addTeam(team)

    fun createTeam() {
        if (!validateData()) {
            status.value = WRONG_DATA
            return
        }

        val newTeam = TeamModel(
            name.value!!,
            sport.value!!,
        )

        addTeam(newTeam)
        clearData()

        status.value = TEAM_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            sport.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        sport.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TeamReviewerApplication
                TeamViewModel(app.teamRepository)
            }
        }

        const val TEAM_CREATED = "Team created"
        const val WRONG_DATA = "Wrong data"
        const val INACTIVE = ""
    }

}