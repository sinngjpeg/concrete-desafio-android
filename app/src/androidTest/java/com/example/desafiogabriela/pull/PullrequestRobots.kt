package com.example.desafiogabriela.pull

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.desafiogabriela.HttpStatus
import com.example.desafiogabriela.MockServerRule
import com.example.desafiogabriela.loadAsFixture
import com.example.desafiogabriela.retryer
import com.example.desafiogabriela.utils.Constant.repository
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

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

    fun enqueueResponseError(){
        mockWebServerRule.mockWebServer.enqueue(MockResponse().setResponseCode(HttpStatus.statusError))
    }

    fun startPullScreen() {

        ActivityScenario.launch(PullrequestActivity::class.java)

    }
}

class pullrequestAct(action: pullrequestAct.() -> Unit){
    init {
        action.invoke(this)
    }
}

class pullrequestAssert(action: pullrequestAssert.() -> Unit){
    init {
        action.invoke(this)
    }
    fun checkTextVisible(text: String){
        retryer {
            onView(withText(text)).check(matches(isDisplayed()))
        }
    }
}











