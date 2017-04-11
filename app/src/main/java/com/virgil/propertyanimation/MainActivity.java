package com.virgil.propertyanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画
 * 最大的特点是：改变对象的实际属性
 */
public class MainActivity extends AppCompatActivity {
    private Context mCtx = this;
    private ImageView mIv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mIv_main = (ImageView) findViewById(R.id.iv_main);
        mIv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mCtx,"小猴子被点了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clickView(View view) {
        //使用XML布局文件设置属性动画
        switch (view.getId()) {
            case R.id.btn_main_alpha_xml:
                ObjectAnimator animator_alpha_xml = (ObjectAnimator) AnimatorInflater.loadAnimator(mCtx,
                        R.animator.alpha);
                animator_alpha_xml.setTarget(mIv_main);
                animator_alpha_xml.start();
                break;
            case R.id.btn_main_rotate_xml:
                ObjectAnimator animator_rotate_xml = (ObjectAnimator) AnimatorInflater.loadAnimator(mCtx,
                        R.animator.rotate);
                animator_rotate_xml.setTarget(mIv_main);
                animator_rotate_xml.start();
                break;
            case R.id.btn_main_scale_xml:
                AnimatorSet animator_scale_xml= (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,R.animator.scale);
                animator_scale_xml.setTarget(mIv_main);
                animator_scale_xml.start();
                break;
            case R.id.btn_main_translate_xml:
                AnimatorSet animator_translate_xml = (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,
                        R.animator.translate);
                animator_translate_xml.setTarget(mIv_main);
                animator_translate_xml.start();
                break;
        }
    }

    public void clickViewSet(View view) {
        switch (view.getId()){
            case R.id.btn_main_set_xml:
                AnimatorSet animator_set_xml= (AnimatorSet) AnimatorInflater.loadAnimator(mCtx,R.animator.set_animator);
                animator_set_xml.setTarget(mIv_main);
                animator_set_xml.start();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent view = new Intent();
        view.setClass(mCtx,NextActivity.class);
        startActivity(view);
        return super.onOptionsItemSelected(item);
    }
}
