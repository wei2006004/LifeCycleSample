package com.vinson.lifecycle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProviders.of(this).get(TestModel::class.java)
        model.data.observe(this, Observer<Int> {
            Log.e("activity", "$it")
        })

        hello.setOnClickListener {
            model.post()
        }
    }
}
