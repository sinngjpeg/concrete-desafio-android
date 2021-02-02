package com.example.desafiogabriela.pull

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.desafiogabriela.MockServerRule
import com.example.desafiogabriela.R
import com.example.desafiogabriela.repository.repositoryArrange
import com.example.desafiogabriela.repository.repositoryAssert
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PullrequestActivityTest {

    @get:Rule
    val mockWebServerRule = MockServerRule()


    @Test
    fun givenRequestSuccessful_shouldRenderPullRequestList() {
        pullrequestArrange(mockWebServerRule){
            enqueueResponse("pull_request.json")
            startPullScreen()
        }
        pullrequestAssert{
            checkTextVisible("Gabriel-18")
        }
    }

    @Test
    fun givenNetworkError_shouldReturnErrorAlertDialog() {
        pullrequestArrange(mockWebServerRule) {
            enqueueResponseError()
            startPullScreen()
        }
        pullrequestAssert {
            checkTextVisible("Erro no servidor")
        }
    }
}