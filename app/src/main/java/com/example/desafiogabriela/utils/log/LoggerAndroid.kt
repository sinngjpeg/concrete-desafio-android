package com.example.desafiogabriela.utils.log

import android.util.Log
import com.example.desafiogabriela.utils.log.Logger

class LoggerAndroid: Logger {
    override fun logMessage(tag: String, message: String) {
        Log.d(tag, message)
    }

}