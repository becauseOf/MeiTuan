package com.xiangsong.meituan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Shop;
import com.xiangsong.meituan.ui.activity.ShopActivity;
import com.xiangsong.meituan.ui.activity.ShopDetailActivity;
import com.xiangsong.meituan.ui.adapter.FoodTypeAdapter;
import com.xiangsong.meituan.ui.adapter.ShopAdapter;
import com.xiangsong.meituan.ui.view.NoScrollGridView;
import com.xiangsong.meituan.ui.view.NoScrollListview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiangsong on 2016/9/11.
 */
public class MainFragment extends Fragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search)
    SearchView searchView;
    @BindView(R.id.option)
    NoScrollGridView option;
    @BindView(R.id.slider)
    SliderLayout sliderLayout;
    @BindView(R.id.shop)
    NoScrollListview shops;

    private List<Integer> imgDatas = new ArrayList<>();
    private List<String> txtDatas = new ArrayList<>();
    private List<Shop> shopDatas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        imgDatas.add(R.drawable.type1);
        imgDatas.add(R.drawable.type2);
        imgDatas.add(R.drawable.type3);
        imgDatas.add(R.drawable.type4);
        imgDatas.add(R.drawable.type5);
        imgDatas.add(R.drawable.type6);
        imgDatas.add(R.drawable.type7);
        imgDatas.add(R.drawable.type8);

        txtDatas.add("美食");
        txtDatas.add("超市");
        txtDatas.add("鲜果购");
        txtDatas.add("甜点饮品");
        txtDatas.add("校园优选");
        txtDatas.add("专送");
        txtDatas.add("夜宵");
        txtDatas.add("快餐");

        Shop shop1 = new Shop(R.drawable.shop1,"欧巴客","月售1123单","起送价¥13","530m");
        Shop shop2 = new Shop(R.drawable.kfc,"肯德基","月售113单","起送价¥23","1130m");
        Shop shop3 = new Shop(R.drawable.gongfu,"真功夫","月售113单","起送价¥23","1130m");

        shopDatas.add(shop1);
        shopDatas.add(shop2);
        shopDatas.add(shop3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        ButterKnife.bind(this, getActivity());

        toolbar.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("输入商家或商家名称...");
        searchView.setFocusable(false);
//        toolbar.inflateMenu(R.menu.search);

        option.setAdapter(new FoodTypeAdapter(getContext(), imgDatas,txtDatas));

        option.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ShopActivity.class));
            }
        });

        //设置首页广告轮播图
        DefaultSliderView defaultSliderView1 = new DefaultSliderView(getContext());
        defaultSliderView1.image(R.mipmap.ic_launcher)
                .setScaleType(BaseSliderView.ScaleType.Fit);

        sliderLayout.addSlider(defaultSliderView1);

        DefaultSliderView defaultSliderView2= new DefaultSliderView(getContext());
        defaultSliderView2.image(R.drawable.ad1)
                .setScaleType(BaseSliderView.ScaleType.Fit);

        sliderLayout.addSlider(defaultSliderView2);

        //设置商家信息
        shops.setAdapter(new ShopAdapter(getContext(), shopDatas));

        shops.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), ShopDetailActivity.class));
            }
        });


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        /*inflater.inflate(R.menu.search,menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("输入商家或商家名称...");
        searchView.setIconifiedByDefault(false);
        searchView.setGravity(Gravity.LEFT);*/
        super.onCreateOptionsMenu(menu, inflater);

    }
}
