package com.example.parcial1pdm.ui.team

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial1pdm.R
import com.example.parcial1pdm.data.model.TeamModel
import com.google.android.material.textfield.TextInputEditText

class NewTeamFragment : Fragment() {

    private val teamViewModel: TeamViewModel by activityViewModels{
        TeamViewModel.Factory
    }

    lateinit var name: TextInputEditText
    lateinit var sport: TextInputEditText
    lateinit var actionSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        actionSubmit.setOnClickListener {
            createTeam()
        }

    }

    private fun bind(view: View){
        name = view.findViewById(R.id.TextField1)
        sport = view.findViewById(R.id.TextField2)
        actionSubmit = view.findViewById(R.id.addTracker)
    }

    private fun createTeam(){
        val newTeam = TeamModel(
            name.text.toString(),
            sport.text.toString(),
        )
        teamViewModel.addTeam(newTeam)

        Log.d("APP TAG", teamViewModel.getTeams().toString())

        findNavController().popBackStack()
    }



}