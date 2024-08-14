package com.apple.matchscores.data

data class Score(
    val description: String,
    val fixture_id: Int,
    val id: Int,
    val participant_id: Int,
    val score: Goals,
    val type_id: Int
)