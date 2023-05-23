package com.example.parcial1pdm.ui.team.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1pdm.data.model.TeamModel
import com.example.parcial1pdm.databinding.TeamItemBinding

class TeamRecyclerViewAdapter(private val clickListener: (TeamModel) -> Unit) : RecyclerView.Adapter<TeamRecyclerViewHolder>() {
    private val teams = ArrayList<TeamModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamRecyclerViewHolder {
        val binding = TeamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamRecyclerViewHolder, position: Int) {
        val team = teams[position]
        holder.bind(team, clickListener)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    fun setData(playerList: List<TeamModel>) {
        teams.clear()
        teams.addAll(playerList)
    }
}