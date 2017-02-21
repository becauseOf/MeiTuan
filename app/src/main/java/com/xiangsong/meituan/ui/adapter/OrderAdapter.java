package com.xiangsong.meituan.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.ProfileItem;

import java.util.List;

/**
 * Created by gala on 2016/7/3.
 */
public class OrderAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ProfileItem> datas;
    private ImageView imageView;
    private TextView textView;
    private Context context;

    public OrderAdapter(Context context, List<ProfileItem> datas) {
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return 3;
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
        if (convertView == null) {
            switch (position){
                case 0:
                    convertView = mInflater.inflate(R.layout.order_item,null);
                    break;
                case 1:
                    convertView = mInflater.inflate(R.layout.order_item1,null);
                    break;
                case 2:
                    convertView = mInflater.inflate(R.layout.order_item2,null);
                    break;
            }
        }


        return convertView;
    }
}
