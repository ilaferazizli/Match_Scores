package com.apple.matchscores.data

data class Api(
    val data: List<Data>,
    val pagination: Pagination,
    val rate_limit: RateLimit,
    val subscription: List<Subscription>,
    val timezone: String
)