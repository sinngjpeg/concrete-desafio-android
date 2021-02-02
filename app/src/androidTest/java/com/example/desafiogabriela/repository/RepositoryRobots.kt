package com.example.desafiogabriela.repository

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.desafiogabriela.api.RetrofitLauncher
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.example.desafiogabriela.HttpStatus
import com.example.desafiogabriela.MockServerRule
import com.example.desafiogabriela.loadAsFixture
import com.example.desafiogabriela.retryer
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

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
    fun enqueueResponseError(){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(HttpStatus.statusError))
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
