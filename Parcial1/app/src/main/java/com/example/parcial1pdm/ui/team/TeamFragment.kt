package com.example.parcial1pdm.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.parcial1pdm.R
import com.example.parcial1pdm.databinding.FragmentTeamBinding
import com.example.parcial1pdm.ui.team.viewmodel.TeamViewModel

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamBinding

    private val teamViewModel: TeamViewModel by activityViewModels{
        TeamViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = teamViewModel
    }

}