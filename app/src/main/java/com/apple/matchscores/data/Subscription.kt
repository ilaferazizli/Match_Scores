package com.apple.matchscores.data

data class Subscription(
    val add_ons: List<Any>,
    val meta: List<Any>,
    val plans: List<Plan>,
    val widgets: List<Any>
)