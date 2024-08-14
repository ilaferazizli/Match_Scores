package com.apple.matchscores.data

data class DataContainer(
    val data: List<Data>,
    val rate_limit: RateLimit,
    val subscription: List<Subscription>,
    val pagination: Pagination,
    val timezone: String
)