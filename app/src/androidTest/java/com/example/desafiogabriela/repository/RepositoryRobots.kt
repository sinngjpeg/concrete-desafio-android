package com.example.desafiogabriela.repository

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.desafiogabriela.utils.HttpStatus
import com.example.desafiogabriela.utils.MockServerRule
import com.example.desafiogabriela.utils.loadAsFixture
import com.example.desafiogabriela.utils.retryer
import okhttp3.mockwebserver.MockResponse
import java.lang.Exception

class repositoryArrange(
    private val mockWebServerRule: MockServerRule,
    action: repositoryArrange.() -> Unit
) {

    init {
        action.invoke(this)
    }

    fun enqueueResponse(responseFileName: String) {
        mockWebServerRule.mockWebServer.enqueue(MockResponse()
            .setBody(responseFileName.loadAsFixture())
        )
    }
    fun enqueueNetworkError(){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(HttpStatus.statusError))
    }

    fun enqueueResponseError(t: Throwable){
       mockWebServerRule.mockWebServer.enqueue(MockResponse())
    }

    fun startRepositoriesScreen() {
        ActivityScenario.launch(RepositoryActivity::class.java)
    }
}

class repositoryAct(action: repositoryAct.() -> Unit) {
    init {
        action.invoke(this)
    }
}
class repositoryAssert(action: repositoryAssert.() -> Unit) {
    init {
        action.invoke(this)
    }
    fun checkTextVisible(text: String){
        retryer {
            onView(withText(text)).check(matches(isDisplayed()))
        }
    }
}
