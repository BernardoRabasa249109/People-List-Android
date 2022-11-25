package com.berny.peopleapp.feature_users.presentation.home

import com.berny.peopleapp.feature_users.domain.model.User

data class HomeState(
    val users: List<User> = emptyList()
)
