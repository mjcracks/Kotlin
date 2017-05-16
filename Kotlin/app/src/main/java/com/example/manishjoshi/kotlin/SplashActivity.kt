package com.example.manishjoshi.kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by manishjoshi on 15/5/17.
 */
class SplashActivity :AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent =Intent(this,MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.abc_slide_in_top,R.anim.abc_slide_in_bottom)
        finish()
    }
}
