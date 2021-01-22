package com.shayanne.desafioshayanne.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.shayanne.desafioshayanne.R
import com.shayanne.desafioshayanne.api.ApiWebClientRequest
import com.shayanne.desafioshayanne.model.ItemsRepositories
import com.shayanne.desafioshayanne.model.Owner
import com.shayanne.desafioshayanne.model.RepositoryRequests
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.mock.Calls
import java.io.IOException


class RepositoryViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val fakeLogger = FakeLogger()
    private val mockwebClient = mockk<ApiWebClientRequest>()
    private val viewModel = RepositoryViewModel(mockwebClient,fakeLogger)

    @Test
    fun givenResponseSuccessful_shouldFillResultListLiveData() {
        val resultList = createFakeReposList()
        // arrange
        every {
            mockwebClient.getRepositories(any())
        } returns Calls.response(ItemsRepositories(resultList))

        // act
        viewModel.loadpage(1)

        // assert
        assertEquals(RepositoryViewState.Sucesso(resultList), viewModel.getViewState().value)
    }

    @Test
    fun givenNetworkError_shouldReturnError() {
        val exceptionThrown = IOException()
        every {
            mockwebClient.getRepositories(any())
        } returns Calls.failure(exceptionThrown)

        viewModel.loadpage(1)

        assertEquals(RepositoryViewState.Erro(R.string.error_network_request_failed ), viewModel.getViewState().value)
    }

    private fun createFakeReposList(): List<RepositoryRequests> {
        return (1..10).map { number ->
            RepositoryRequests(
                name = "name $number",
                description = "description $number",
                forksCount = number,
                stargazersCount = number * 2,
                owner = Owner(avatarUrl = "https://google.com", login = "joao"),
                fullName = "Joao $number"
            )
        }
    }
}




