package com.sinngjpeg.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PullRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pull_request_activity)

        setSupportActionBar(findViewById(R.id.toolbar_pullrequest))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)






    }
}