package com.xiangsong.meituan.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Food;
import com.xiangsong.meituan.model.Shop;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gala on 2016/7/3.
 */
public class FoodAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Food> datas;
    private Context context;

    public FoodAdapter(Context context, List<Food> datas) {
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.food_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imgFood.setImageResource(datas.get(position).getImgResource());
        viewHolder.title.setText(datas.get(position).getTitle());
        viewHolder.amount.setText(datas.get(position).getAmount());
        viewHolder.price.setText(datas.get(position).getPrice());

        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.img_food)
        ImageView imgFood;
        @BindView(R.id.food_title)
        TextView title;
        @BindView(R.id.amount)
        TextView amount;
        @BindView(R.id.price)
        TextView price;
        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
