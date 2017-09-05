package com.fengwenyi.android_animation

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 * WenyiFeng(xfsy2014@gmail.com)
 * 2017-09-05 15:00
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mContext : Context

    override fun onClick(view: View?) {
        val loadAnimation : Animation

        when(view?.id) {
            /** 缩放 */
            R.id.btnScales -> {
                loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.scales)
                imgView.startAnimation(loadAnimation)
            }
            /** 透明度 */
            R.id.btnAlpha -> {
                loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.alpha)
                imgView.startAnimation(loadAnimation)
            }
            /** 旋转 */
            R.id.btnRotate -> {
                loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.rotate)
                imgView.startAnimation(loadAnimation)
            }
            /** 位移 */
            R.id.btnTranslate -> {
                loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.translate)
                imgView.startAnimation(loadAnimation)
            }
            /** 切换 */
            R.id.btnChange -> {
                val intent = Intent(mContext, SecondActivity::class.java)
                mContext.startActivity(intent)
                overridePendingTransition(R.anim.alpha, R.anim.rotate)
            }
            /** 闪烁 */
            R.id.btnFlash -> {
                val alphaAnimation = AlphaAnimation(0f, 0.5f)
                alphaAnimation.duration = 100
                alphaAnimation.repeatCount = 50
                alphaAnimation.repeatMode = Animation.REVERSE
                imgView.startAnimation(alphaAnimation)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this

        /** 点击 */
        btnScales.setOnClickListener(this)
        btnAlpha.setOnClickListener(this)
        btnRotate.setOnClickListener(this)
        btnTranslate.setOnClickListener(this)
        btnChange.setOnClickListener(this)
        btnFlash.setOnClickListener(this)
    }
}
