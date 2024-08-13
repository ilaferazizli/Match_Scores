package com.apple.matchscores.data

data class RateLimit(
    val remaining: Int,
    val requested_entity: String,
    val resets_in_seconds: Int
)