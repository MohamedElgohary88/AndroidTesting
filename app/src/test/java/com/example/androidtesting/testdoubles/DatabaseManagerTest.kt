package com.example.androidtesting.testdoubles

import org.junit.Assert.assertEquals
import org.junit.Test

class DatabaseManagerTest {

    @Test
    fun ` test fake test doubles scenario`() {
        val database = InMemoryDatabase()
        val databaseManager = DatabaseManager(database)
        databaseManager.save("mohamed")
        val result = databaseManager.get()
        assertEquals("mohamed", result)
    }
}