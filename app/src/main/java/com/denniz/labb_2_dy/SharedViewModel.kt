package com.denniz.labb_2_dy

import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    var sharedData: String = ""

    fun greetingText(): String {
        return "Hello $sharedData!"
    }
}