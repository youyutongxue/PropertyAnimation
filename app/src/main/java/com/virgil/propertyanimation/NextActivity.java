package com.virgil.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NextActivity extends AppCompatActivity {
    private Context mCtx = this;
    private ImageView mIv_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        intiView();
    }

    private void intiView() {
        mIv_next = (ImageView) findViewById(R.id.iv_next);
        mIv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx, "小猴子被点了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 单个动画演示
     *
     * @param view
     */
    public void clickView(View view) {
        //采用代码来实现属性动画
        switch (view.getId()) {
            case R.id.btn_main_alpha:
                ObjectAnimator animator_alpha = ObjectAnimator.ofFloat(mIv_next,
                        "alpha", 0.0f, 1.0f);
                animator_alpha.setDuration(3000);
                animator_alpha.setRepeatCount(ValueAnimator.INFINITE);
                animator_alpha.setRepeatMode(ValueAnimator.REVERSE);
                animator_alpha.start();
                break;
            case R.id.btn_main_rotate:
                ObjectAnimator animator_rotate = ObjectAnimator.ofFloat(mIv_next,
                        "rotation", 0, 360);
                animator_rotate.setDuration(3000);
                animator_rotate.setRepeatCount(ValueAnimator.INFINITE);
                animator_rotate.setRepeatMode(ValueAnimator.REVERSE);
                animator_rotate.start();
                break;
            case R.id.btn_main_scale:
                ObjectAnimator animator_scaleX = ObjectAnimator.ofFloat(mIv_next,
                        "scaleX", 0, 2.0f);
                ObjectAnimator animator_scaleY = ObjectAnimator.ofFloat(mIv_next,
                        "scaleY", 0, 2.0f);

                animator_scaleX.setDuration(3000);
                animator_scaleX.setRepeatCount(ValueAnimator.INFINITE);
                animator_scaleX.setRepeatMode(ValueAnimator.REVERSE);
                animator_scaleX.start();

                animator_scaleY.setDuration(3000);
                animator_scaleY.setRepeatCount(ValueAnimator.INFINITE);
                animator_scaleY.setRepeatMode(ValueAnimator.REVERSE);
                animator_scaleY.start();
                break;
            case R.id.btn_main_translate:
                ObjectAnimator animator_translationX = ObjectAnimator.ofFloat(mIv_next,
                        "translationX", 0, 200);
                ObjectAnimator animator_translationY = ObjectAnimator.ofFloat(mIv_next,
                        "translationY", 0, 200);

                animator_translationX.setDuration(3000);
                animator_translationX.setRepeatCount(ValueAnimator.INFINITE);
                animator_translationX.setRepeatMode(ValueAnimator.REVERSE);
                animator_translationX.start();

                animator_translationY.setDuration(3000);
                animator_translationY.setRepeatCount(ValueAnimator.INFINITE);
                animator_translationY.setRepeatMode(ValueAnimator.REVERSE);
                animator_translationY.start();
                break;
        }
    }

    /**
     * 组合动画演示
     *
     * @param view
     */
    public void clickViewSet(View view) {
        AnimatorSet animatorSet = new AnimatorSet();

        //绕圈
        ObjectAnimator animator_toRight = ObjectAnimator.ofFloat(mIv_next,
                "translationX", 0, 500);
        animator_toRight.setDuration(3000);
        animator_toRight.setInterpolator(new BounceInterpolator());

        ObjectAnimator animator_below = ObjectAnimator.ofFloat(mIv_next,
                "translationY", 0, 500);
        animator_below.setDuration(3000);
        animator_below.setInterpolator(new BounceInterpolator());

        ObjectAnimator animator_toLeft = ObjectAnimator.ofFloat(mIv_next,
                "translationX", 500, 0);
        animator_toLeft.setDuration(3000);
        animator_toLeft.setInterpolator(new BounceInterpolator());

        ObjectAnimator animator_up = ObjectAnimator.ofFloat(mIv_next,
                "translationY", 500, 0);
        animator_up.setDuration(3000);
        animator_up.setInterpolator(new BounceInterpolator());

        List<Animator> list = new ArrayList<>();
        list.add(animator_toRight);
        list.add(animator_below);
        list.add(animator_toLeft);
        list.add(animator_up);

        animatorSet.playSequentially(list);
        animatorSet.start();
    }
}
