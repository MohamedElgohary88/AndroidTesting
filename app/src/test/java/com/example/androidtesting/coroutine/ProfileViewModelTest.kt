package com.example.androidtesting.coroutine

import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ProfileViewModelTest {

    @get: Rule
    val mainDispatcherRule = MainDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test success scenario`() = runTest {
        val useCase: GetUserProfile = mockk()
        coEvery { useCase.getProfileDataAsync() } coAnswers { TestingUtils.dummyProfileData }
        val viewModel = ProfileViewModel(useCase)

        viewModel.getUserProfile()

        advanceUntilIdle()

        assertEquals(
            ProfileUIState.Success(TestingUtils.dummyProfileData),
            viewModel.profileUIState.value
        )
    }

    @Test
    fun `test failure scenario`() = runTest {
        val usecase: GetUserProfile = mockk()
        coEvery { usecase.getProfileDataAsync() } throws IllegalStateException("error")
        val viewModel = ProfileViewModel(usecase)

        viewModel.getUserProfile()

        advanceUntilIdle()

        assertEquals(ProfileUIState.Error("error"), viewModel.profileUIState.value)
    }
}

class MainDispatcherRule(val testDispatcher: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}