package com.example.desafiogabriela.pull

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.desafiogabriela.utils.MockServerRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class PullRequestActivityTest {

    @get:Rule
    val mockWebServerRule = MockServerRule()

    @Test
    fun givenRequestSuccessful_shouldRenderPullRequestList() {
        pullrequestArrange(mockWebServerRule) {
            enqueueResponse("pull_request.json")
            startPullScreen()
        }
        pullrequestAssert {
            checkTextVisible("Gabriel-18")
        }
    }

    @Test
    fun givenNetworkError_shouldReturnErrorAlertDialog() {
        pullrequestArrange(mockWebServerRule) {
            enqueueNetworkError()
            startPullScreen()
        }
        pullrequestAssert {
            checkTextVisible("Erro no servidor")
        }
    }

    @Test
    fun givenFailureResponse_shouldReturnErrorAlertDialog() {
        pullrequestArrange(mockWebServerRule) {
            enqueueResponseError(IOException())
            startPullScreen()
        }
        pullrequestAssert {
            checkTextVisible("Erro desconhecido")
        }
    }
}