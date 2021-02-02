package com.example.desafiogabriela.pull

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.desafiogabriela.utils.HttpStatus
import com.example.desafiogabriela.utils.MockServerRule
import com.example.desafiogabriela.utils.loadAsFixture
import com.example.desafiogabriela.utils.retryer
import okhttp3.mockwebserver.MockResponse

class pullrequestArrange(
    private val mockWebServerRule: MockServerRule,
    action: pullrequestArrange.() -> Unit
) {
    init {
        action.invoke(this)
    }

    fun enqueueResponse(fileName: String) {
        mockWebServerRule.mockWebServer.enqueue(MockResponse()
            .setBody(fileName.loadAsFixture()))
    }

    fun enqueueNetworkError() {
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(HttpStatus.statusError))
    }

    fun enqueueResponseError(t: Throwable) {
        mockWebServerRule.mockWebServer.enqueue(MockResponse())
    }

    fun startPullScreen() {

        ActivityScenario.launch(PullrequestActivity::class.java)

    }
}

class pullrequestAct(action: pullrequestAct.() -> Unit) {
    init {
        action.invoke(this)
    }
}

class pullrequestAssert(action: pullrequestAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun checkTextVisible(text: String) {
        retryer {
            onView(withText(text)).check(matches(isDisplayed()))
        }
    }
}











