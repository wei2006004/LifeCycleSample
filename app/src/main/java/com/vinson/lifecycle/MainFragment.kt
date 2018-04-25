package com.vinson.lifecycle

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return View(activity)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model = ViewModelProviders.of(activity!!).get(TestModel::class.java)
        model.data.observe(this, Observer<Int> {
            Log.e("fragment", "$it")
        })

        val fraModel = ViewModelProviders.of(this).get(TestModel::class.java)
        fraModel.data.observe(this, Observer<Int> {
            Log.e("fragment", "fragment $it")
        })

        Handler().postDelayed( { fraModel.post() }, 1000)
    }
}