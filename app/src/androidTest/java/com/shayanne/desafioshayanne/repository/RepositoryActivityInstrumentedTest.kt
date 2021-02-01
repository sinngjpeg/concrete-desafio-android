package com.shayanne.desafioshayanne.repository


import androidx.test.ext.junit.runners.AndroidJUnit4
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryInstrumentedTestActivityTest {



    //@get:Rule
    private val mockWebServer = MockWebServer()

    // antes do teste de um delay
    //idling faz o delay para aguardar a info chegar
    @Before
    fun setup() {
        repositoryArrange(mockWebServer) {
            registerIdlingResource()
        }
    }


    // depois do teste, desligue o sistema
    @After
    fun teardown() {
        repositoryArrange(mockWebServer) {
            shutdownServer()
        }
    }

    // o teste de sucesso:
    @Test
    fun givenRequestSucessful_shouldRenderRepositoriesList() {
        repositoryArrange(mockWebServer) {
            enqueueResponse("resposta_sucesso.json")
            //inicie o servidor:
            startServer()
            //inicie a tela da activity:
            startRepositoryScreen()
        }
        Assert{
            checkTextVisible("CS-Notes")
        }
    }

    // Erro de conexão:
    @Test
    fun givenRequestFail_should() {
        repositoryArrange(mockWebServer) {
            enqueueResponse(" ")
            //inicie o servidor:
            startServer()
            //inicie a tela da activity:
            startRepositoryScreen()
        }
        Assert{
            checkTextVisible(" ")
        }
    }
    //Erro de Servidor

}