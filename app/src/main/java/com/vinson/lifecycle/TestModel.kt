package com.vinson.lifecycle

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.os.Looper
import kotlin.concurrent.thread

class TestModel : ViewModel() {

    val data = MutableLiveData<Int>()

    fun post() {
        result(0)
        thread {
            (1..4).forEach {
                Thread.sleep(1000)
                result(it)
            }
            result(5)
        }
    }

    fun other() {
        thread {
            (5..8).forEach {
                Thread.sleep(1000)
                result(it)
            }
        }
    }

    private fun result(result: Int) {
        Handler(Looper.getMainLooper()).post {
            data.value = result
        }
    }
}