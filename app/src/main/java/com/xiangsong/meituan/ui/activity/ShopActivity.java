package com.xiangsong.meituan.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Shop;
import com.xiangsong.meituan.ui.adapter.ShopAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar myChildToolbar;
    @BindView(R.id.shop)
    ListView shops;
    private List<Shop> shopDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ButterKnife.bind(this);

        myChildToolbar.setTitle("美食");
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Shop shop1 = new Shop(R.drawable.shop1,"欧巴客","月售1123单","起送价¥13","530m");
        Shop shop2 = new Shop(R.drawable.kfc,"肯德基","月售113单","起送价¥23","1130m");
        Shop shop3 = new Shop(R.drawable.gongfu,"真功夫","月售113单","起送价¥23","1130m");

        shopDatas.add(shop1);
        shopDatas.add(shop2);
        shopDatas.add(shop3);

        //设置商家信息
        shops.setAdapter(new ShopAdapter(this, shopDatas));

        shops.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ShopActivity.this, ShopDetailActivity.class));
            }
        });

    }
}
