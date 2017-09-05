# Android�������ܽ�
1��Android�����������Զ����ʹ�ͳ������֡�����Ͳ��䶯����
2��Android����������ʵ�ַ�ʽ��XML���ú�Java��Kotlin������ʵ��
3����������ʵ��ʾ��
### ��һ����  ��
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

### ��һ��͸����
```
<alpha
    android:duration="5000"
    android:fromAlpha="0"
    android:toAlpha="1"
    />
```

### ��һ����  ת
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

### ��һ��λ  ��
```
<translate
    android:duration="10000"
    android:fromXDelta="500"
    android:fromYDelta="0"
    android:toXDelta="0"
    android:toYDelta="0"
    />
```

Kotlin����: ������XML�ļ�Ӧ�õ�image��
```
val loadAnimation : Animation

when(view?.id) {
    /** ���� */
    R.id.btnScales -> {
        loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.scales)
        imgView.startAnimation(loadAnimation)
    }
    /** ͸���� */
    R.id.btnAlpha -> {
        loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.alpha)
        imgView.startAnimation(loadAnimation)
    }
    /** ��ת */
    R.id.btnRotate -> {
        loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.rotate)
        imgView.startAnimation(loadAnimation)
    }
    /** λ�� */
    R.id.btnTranslate -> {
        loadAnimation = AnimationUtils.loadAnimation(mContext, R.anim.translate)
        imgView.startAnimation(loadAnimation)
    }
    /** �л� */
    R.id.btnChange -> {
        val intent = Intent(mContext, SecondActivity::class.java)
        mContext.startActivity(intent)
        overridePendingTransition(R.anim.alpha, R.anim.rotate)
    }
    /** ��˸ */
    R.id.btnFlash -> {
        val alphaAnimation = AlphaAnimation(0f, 0.5f)
        alphaAnimation.duration = 100
        alphaAnimation.repeatCount = 50
        alphaAnimation.repeatMode = Animation.REVERSE
        imgView.startAnimation(alphaAnimation)
    }
}
```

### ֡����
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

Kotlin����

```
imgAnimation.setImageResource(R.drawable.loading)
val animationDrawable : AnimationDrawable = imgAnimation.drawable as AnimationDrawable
animationDrawable.start()
```

���Ͼ���Android����ʵ�ֵĴ��루Kotlin�����漰Java��ʵ�֣���������κ����⣬����ͨ��E-mail����ʽ�����ң���һ����������