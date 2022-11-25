package com.berny.peopleapp.feature_users.domain.use_cases

import com.berny.peopleapp.feature_users.domain.model.User
import com.berny.peopleapp.feature_users.domain.repository.UserRepository
import javax.inject.Inject

class InsertUser @Inject constructor(
    private var repository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        repository.insertUser(user)
    }
}