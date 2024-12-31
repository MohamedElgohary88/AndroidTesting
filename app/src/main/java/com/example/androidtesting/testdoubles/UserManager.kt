package com.example.androidtesting.testdoubles

import java.util.logging.Logger

class UserManager(val logger: Logger) {
    val usersList = mutableListOf<User>()
    fun addUser(user: User) {
        usersList.add(user)
    }
}

data class User(val username: String)