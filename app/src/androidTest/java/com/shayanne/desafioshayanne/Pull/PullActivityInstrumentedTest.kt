package com.shayanne.desafioshayanne.Pull

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder
import com.shayanne.desafioshayanne.repository.repositoryArrange
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PullActivityInstrumentedTest {

    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        pullArrange(mockWebServer){
            registerIdlingResource()
        }
    }


    @After
    fun teardown(){
        pullArrange(mockWebServer){
            shutdownServer()
        }
    }

    @Test
    fun givenRequestSucessful_shouldRenderPullList(){
        pullArrange(mockWebServer){
            enqueueResponse("resposta_sucesso_pull.json")
            startServer()
            startRepositoryScreen()
        }
        Assert{
            checkTextVisible( "CS-Notes")
        }
    }
}
