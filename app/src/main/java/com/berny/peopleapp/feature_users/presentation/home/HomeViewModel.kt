package com.berny.peopleapp.feature_users.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berny.peopleapp.feature_users.domain.use_cases.DeleteUser
import com.berny.peopleapp.feature_users.domain.use_cases.GetUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val deleteUser: DeleteUser,
    getUsers: GetUsers
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getUsers().onEach { users ->
            _state.value = state.value.copy(
                users = users
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteUser -> {
                viewModelScope.launch {
                    deleteUser(event.user)
                }
            }
        }
    }
}