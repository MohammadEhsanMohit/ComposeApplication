package com.example.composeapplication.feature_profile.domain.model

data class Profile(
    val name: String,
    val country: String,
    val follower: Long,
    val following: Long,
    val post: Long
)