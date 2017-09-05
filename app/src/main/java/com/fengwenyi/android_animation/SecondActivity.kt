package com.fengwenyi.android_animation

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-09-05 15:11
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        animation()
    }

    private fun animation() {
        imgAnimation.setImageResource(R.drawable.loading)
        val animationDrawable : AnimationDrawable = imgAnimation.drawable as AnimationDrawable
        animationDrawable.start()
    }
}