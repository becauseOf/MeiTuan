package com.xiangsong.meituan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.xiangsong.meituan.R;
import com.xiangsong.meituan.ui.adapter.OrderAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xiangsong on 2016/9/11.
 */
public class OrderFragment extends Fragment {

    @BindView(R.id.orders)
    ListView orders;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        ButterKnife.bind(this, getActivity());

        orders.setAdapter(new OrderAdapter(getContext(), null));

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        /*MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("输入商家或商家名称...");
        searchView.setIconifiedByDefault(false);*/

    }
}
