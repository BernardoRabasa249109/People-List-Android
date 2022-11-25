package com.berny.peopleapp.feature_users.presentation.home

import com.berny.peopleapp.feature_users.domain.model.User

sealed class HomeEvent {
    data class DeleteUser(val user: User):  HomeEvent()
}
