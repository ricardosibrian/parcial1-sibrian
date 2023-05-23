package com.example.parcial1pdm.ui.team.newteam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.parcial1pdm.databinding.FragmentNewTeamBinding
import com.example.parcial1pdm.ui.team.viewmodel.TeamViewModel

class NewTeamFragment : Fragment() {

    private lateinit var binding: FragmentNewTeamBinding

    private val teamViewModel: TeamViewModel by activityViewModels{
        TeamViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()

        }

    private fun setViewModel() {
        binding.viewmodel = teamViewModel
    }

    private fun observeStatus() {
        teamViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(TeamViewModel.WRONG_DATA) -> {
                    Log.d("APP TAG", status)
                    teamViewModel.clearStatus()
                }
                status.equals(TeamViewModel.TEAM_CREATED) -> {
                    Log.d("APP TAG", status)
                    Log.d("APP TAG", teamViewModel.getTeams().toString())

                    teamViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }



}