package com.virgil.propertyanimation;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private TextView mTv_th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
        performAnimate();
    }

    private void initView() {
        mTv_th = (TextView) findViewById(R.id.tv_th);
    }

    private void performAnimate() {
        ValueAnimator colorAnim = ObjectAnimator.ofInt(mTv_th, "backgroundColor", 0xFFFF8080, 0xFF8080FF);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }
}
