package com.example.desafiogabriela.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.desafiogabriela.MockServerRule
import com.example.desafiogabriela.R
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryActivityTest {

    @get:Rule
    val mockWebServerRule = MockServerRule()

    @Test
    fun givenRequestSuccessful_shouldRenderRepositoriesList() {
        repositoryArrange(mockWebServerRule) {
            enqueueResponse("repositories.json")
            startRepositoriesScreen()
        }
        repositoryAssert {
            checkTextVisible("CS-Notes")

        }
    }

    @Test
    fun givenNetworkError_shouldReturnErrorAlertDialog() {
        repositoryArrange(mockWebServerRule) {
            enqueueResponseError()
            startRepositoriesScreen()
        }
        repositoryAssert {
            checkTextVisible("Erro no servidor")
        }
    }
}
