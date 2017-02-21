package com.xiangsong.meituan.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.ui.fragment.MainFragment;
import com.xiangsong.meituan.ui.fragment.OrderFragment;
import com.xiangsong.meituan.ui.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindViews({R.id.linear_main,R.id.linear_order,R.id.linear_profile})
    List<LinearLayout> linears;
    @BindViews({R.id.main,R.id.order,R.id.profile})
    List<ImageView> imgs;
    @BindViews({R.id.tv_main,R.id.tv_main_order,R.id.tv_main_profile})
    List<TextView> txts;

    //存储图片资源
    List<Integer> imgsResourceGreen = new ArrayList<>();
    List<Integer> imgsResourceGray = new ArrayList<>();

    //当前页面所在的位置
    private int index = 0;
    private FragmentManager fragmentManager;
    private Fragment mainFrgment;
    private Fragment orderFrgment;
    private Fragment profileFrgment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    private void init(){
        ButterKnife.bind(this);
        for(LinearLayout linear: linears) {
            linear.setOnClickListener(this);
        }

        fragmentManager = getSupportFragmentManager();

        //这里其实可以用资源数组吧
        imgsResourceGreen.add(R.drawable.main_green);
        imgsResourceGreen.add(R.drawable.order_green);
        imgsResourceGreen.add(R.drawable.profile_green);

        imgsResourceGray.add(R.drawable.main_gray);
        imgsResourceGray.add(R.drawable.order_gray);
        imgsResourceGray.add(R.drawable.profile_gray);

        setTabSelection();
    }

    private void resetColor(){

        for (int i = 0; i < imgs.size(); i++) {
            imgs.get(i).setImageResource(imgsResourceGray.get(i));
            txts.get(i).setTextColor(getResources().getColor(R.color.colorMainTxt));
        }
    }

    public void changeColor(View v) {
        resetColor();
        index = linears.indexOf(v);
        txts.get(index).setTextColor(getResources().getColor(R.color.colorPrimary));
        imgs.get(index).setImageResource(imgsResourceGreen.get(index));
    }



    @Override
    public void onClick(View v) {
        changeColor(v);
        setTabSelection();
    }

    private void setTabSelection(){
        //改变当前的fragment页面
        FragmentTransaction  transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index){
            case 0:
                if (mainFrgment == null) {
                    //如果为空，则创建一个并添加到界面上
                    mainFrgment = new MainFragment();
                    transaction.add(R.id.content,mainFrgment);
                }else{
                    transaction.show(mainFrgment);
                }
                break;
            case 1:
                if (orderFrgment == null) {
                    //如果为空，则创建一个并添加到界面上
                    orderFrgment = new OrderFragment();
                    transaction.add(R.id.content,orderFrgment);
                }else{
                    transaction.show(orderFrgment);
                }
                break;
            case 2:
                if (profileFrgment == null) {
                    //如果为空，则创建一个并添加到界面上
                    profileFrgment = new ProfileFragment();
                    transaction.add(R.id.content, profileFrgment);
                }else{
                    transaction.show(profileFrgment);
                }
                break;
        }

        transaction.commit();
    }

    /**
     * 将所有的fragment设置为隐藏状态
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mainFrgment != null) {
            transaction.hide(mainFrgment);
        }
        if (orderFrgment != null) {
            transaction.hide(orderFrgment);
        }
        if (profileFrgment != null) {
            transaction.hide(profileFrgment);
        }
    }
}
