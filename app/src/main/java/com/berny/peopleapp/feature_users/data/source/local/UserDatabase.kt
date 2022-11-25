package com.berny.peopleapp.feature_users.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berny.peopleapp.feature_users.data.source.local.dao.UserDao
import com.berny.peopleapp.feature_users.domain.model.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao

}