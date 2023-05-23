package com.example.parcial1pdm.ui.team.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1pdm.data.model.TeamModel
import com.example.parcial1pdm.databinding.TeamItemBinding

class TeamRecyclerViewHolder(private val binding: TeamItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(team: TeamModel, clickListener: (TeamModel) -> Unit) {
        binding.Title.text = team.name
        binding.secondTitle.text = team.sport

        binding.card.setOnClickListener {
            clickListener(team)
        }
    }
}