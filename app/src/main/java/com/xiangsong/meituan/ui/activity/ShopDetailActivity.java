package com.xiangsong.meituan.ui.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Food;
import com.xiangsong.meituan.model.Shop;
import com.xiangsong.meituan.ui.adapter.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar myChildToolbar;
    @BindView(R.id.food)
    ListView foods;
    private List<Food> foodDatas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        ButterKnife.bind(this);


        myChildToolbar.setTitle("欧巴克");
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Food food1 = new Food(R.drawable.food1,"羊肉泡馍","月售709","¥14");
        Food food2 = new Food(R.drawable.food2,"烩面","月售209","¥25");
        Food food3 = new Food(R.drawable.food3,"牛肉饼","月售309","¥13");
        Food food4 = new Food(R.drawable.food4,"拉面","月售70","¥55");

        foodDatas.add(food1);
        foodDatas.add(food2);
        foodDatas.add(food3);
        foodDatas.add(food4);

        foods.setAdapter(new FoodAdapter(this, foodDatas));
    }
}
