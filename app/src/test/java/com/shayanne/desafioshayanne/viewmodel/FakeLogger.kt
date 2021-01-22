package com.shayanne.desafioshayanne.viewmodel

import com.shayanne.desafioshayanne.utils.Logger

class FakeLogger: Logger {

    override fun logMessage(tag: String, message: String) {
        // Não faz nada
    }

}