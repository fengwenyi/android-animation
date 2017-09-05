# Android动画简单总结
1、Android动画包括属性动画和传统动画（帧动画和补间动画）
2、Android动画有两种实现方式：XML设置和Java（Kotlin）代码实现
3、常见动画实现示例
### 〈一〉缩  放
```
<scale
    android:duration="2000"
    android:fillAfter="false"
    android:fromXScale="0.0"
    android:fromYScale="0.0"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"
    android:pivotX="50%"
    android:pivotY="50%"
    android:toXScale="1.0"
    android:toYScale="1.0"
    />
```

### 〈一〉透明度
```
<alpha
    android:duration="5000"
    android:fromAlpha="0"
    android:toAlpha="1"
    />
```

### 〈一〉旋  转
```
<rotate
    android:duration="500"
    android:fromDegrees="0"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"
    android:pivotX="50%"
    android:pivotY="50%"
    android:toDegrees="+360"
    />
```

### 〈一〉位  移
```
<translate
    android:duration="10000"
    android:fromXDelta="500"
    android:fromYDelta="0"
    android:toXDelta="0"
    android:toYDelta="0"
    />
```

Kotlin代码: 将以上XML文件应用到image上
```
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
```

### 帧动画
```
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:drawable="@drawable/ic_1"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_2"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_3"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_4"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_5"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_6"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_7"
        android:duration="100" />
    <item
        android:drawable="@drawable/ic_8"
        android:duration="100" />

</animation-list>
```

Kotlin代码

```
imgAnimation.setImageResource(R.drawable.loading)
val animationDrawable : AnimationDrawable = imgAnimation.drawable as AnimationDrawable
animationDrawable.start()
```

以上就是Android动画实现的代码（Kotlin，不涉及Java）实现，如果你有任何问题，可以通过E-mail的形式告诉我，我一定尽力改正