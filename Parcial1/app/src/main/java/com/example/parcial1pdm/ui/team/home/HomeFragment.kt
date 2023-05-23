package com.example.parcial1pdm.ui.team.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial1pdm.R
import com.example.parcial1pdm.data.model.TeamModel
import com.example.parcial1pdm.databinding.FragmentHomeBinding
import com.example.parcial1pdm.ui.team.home.recyclerview.TeamRecyclerViewAdapter
import com.example.parcial1pdm.ui.team.viewmodel.TeamViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    private val teamViewModel: TeamViewModel by activityViewModels {
        TeamViewModel.Factory
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: TeamRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.buttonAdd.setOnClickListener {
            teamViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newTeamFragment)
        }
    }

    // Funciones para implementar el RecyclerView

    private fun showSelectedItem(team: TeamModel) {
        teamViewModel.setSelectedTeam(team)
        findNavController().navigate(R.id.action_homeFragment_to_teamFragment)
    }

    private fun displayTeams() {
        adapter.setData(teamViewModel.getTeams())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = TeamRecyclerViewAdapter { selectedTeam ->
            showSelectedItem(selectedTeam)
        }

        binding.RecyclerView.adapter = adapter
        displayTeams()
    }



}