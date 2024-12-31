package com.example.androidtesting.testdoubles

import android.os.UserManager
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.logging.Logger

class UserManagerTest {

    @Test
    fun `test dummy test doubles`() {
        val logger: Logger = mockk()
        val userManager = UserManager(logger)
        userManager.addUser(User("mohamed"))
        assertEquals(1, userManager.usersList.size)
    }
}