package com.shayanne.desafioshayanne.pull

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shayanne.desafioshayanne.repository.repositoryArrange
import com.shayanne.desafioshayanne.util.MockWebServerRule
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PullActivityInstrumentedTest {
    @get:Rule
     val mockWebServerRule = MockWebServerRule()

/*@Before
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
    }*/


    // o teste de sucesso:
    @Test
    fun givenRequestSucessful_shouldRenderPullList(){
        pullArrange(mockWebServerRule){
            enqueueResponse("resposta_sucesso_pull.json")
            startPullScreen()
        }
        Assert {
            checkTextVisible( "CS-Notes")
        }
    }

    //Erro de Servidor
    @Test
    fun givenRequestError_shouldShowUnkownError() {
        pullArrange(mockWebServerRule) {
            enqueueMockServerError()
            startPullScreen()
        }
        Assert {
            checkTextVisible("Erro desconhecido")
        }
    }

    // Erro de conexão:
    @Test
    fun givenRequestFail_shouldShowRequestFailed() {
        // ao usar o mock em teste instrumentado vc nao testa o parse, por isso nao é recomendado
        pullArrange(mockWebServerRule) {
            //estamos dizendo o que queremos que o servidor responda
            enqueueMockServerRequestError(Throwable())
            //inicie a tela da activity:
            startPullScreen()

            com.shayanne.desafioshayanne.repository.Assert {
                checkTextVisible("Ocorreu um erro ao processar sua requisição. Tentar novamente?")
            }
        }
    }

}
