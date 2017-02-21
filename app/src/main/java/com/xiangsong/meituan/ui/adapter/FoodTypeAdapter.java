package com.xiangsong.meituan.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.xiangsong.meituan.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by gala on 2016/7/3.
 */
public class FoodTypeAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Integer> imgDatas;
    private List<String> txtDatas;
    private Context context;

    public FoodTypeAdapter(Context context, List<Integer> imgDatas, List<String> txtDatas) {
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.imgDatas = imgDatas;
        this.txtDatas = txtDatas;
    }

    @Override
    public int getCount() {
        return imgDatas.size();
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
            convertView = mInflater.inflate(R.layout.food_type_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imgType.setImageResource(imgDatas.get(position));
        viewHolder.txtType.setText(txtDatas.get(position));

        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.img_type)
        ImageView imgType;
        @BindView(R.id.txt_type)
        TextView txtType;
        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
