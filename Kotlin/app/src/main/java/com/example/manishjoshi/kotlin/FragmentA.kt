package com.example.manishjoshi.kotlin

import android.app.Fragment
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by manishjoshi on 4/4/17.
 */
class FragmentA: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view= inflater!!.inflate(R.layout.fragment_a,container,false)
                return view
    }
    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {

        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

    }
}