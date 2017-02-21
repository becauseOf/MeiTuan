package com.xiangsong.meituan.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Address;
import com.xiangsong.meituan.model.Shop;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gala on 2016/7/3.
 */
public class AddressAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Address> datas;
    private Context context;

    public AddressAdapter(Context context, List<Address> datas) {
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
            convertView = mInflater.inflate(R.layout.address_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.address.setText(datas.get(position).getTitle());
        viewHolder.name.setText(datas.get(position).getName());
        viewHolder.phone.setText(datas.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder{
        @BindView(R.id.address)
        TextView address;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.phone)
        TextView phone;
        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
