package com.example.parcial1pdm.data

import com.example.parcial1pdm.data.model.TeamModel

val name = "Manchester United"
val sport = "Football"

val name2 = "Real Madrid"
val sport2 = "Football"

var teams = mutableListOf(
    TeamModel(name, sport),
    TeamModel(name2, sport2)
)