package com.xiangsong.meituan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.ProfileItem;
import com.xiangsong.meituan.ui.activity.AddressActivity;
import com.xiangsong.meituan.ui.adapter.ProfileAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiangsong on 2016/9/11.
 */
public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_lv1)
    ListView listview1;
    @BindView(R.id.profile_lv2)
    ListView listview2;

    List<ProfileItem> datas1;
    List<ProfileItem> datas2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        ButterKnife.bind(this, getActivity());

        datas1 = new ArrayList<>();
        datas2 = new ArrayList<>();

        datas1.add(new ProfileItem(R.drawable.profile_detail,"我的地址"));
        datas1.add(new ProfileItem(R.drawable.profile_sys_mes,"系统消息"));

        datas2.add(new ProfileItem(R.drawable.profile_feedback,"产品意见"));
        datas2.add(new ProfileItem(R.drawable.profile_version,"版本检测"));
        datas2.add(new ProfileItem(R.drawable.profile_about,"关于"));


        listview1.setAdapter(new ProfileAdapter(getContext(), datas1));

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(getContext(), AddressActivity.class));
                }
            }
        });
        listview2.setAdapter(new ProfileAdapter(getContext(), datas2));

        setListViewHeight(listview1);
        setListViewHeight(listview2);

    }

    public void setListViewHeight(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
