package com.xiangsong.meituan.ui.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.xiangsong.meituan.R;
import com.xiangsong.meituan.model.Address;
import com.xiangsong.meituan.ui.adapter.AddressAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar myChildToolbar;
    @BindView(R.id.addresses)
    ListView addresses;
    private List<Address> addressesData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);

        myChildToolbar.setTitle("我的收货地址");
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        Address address1 = new Address("华南理工大学大学城校区c6 344","王泓瑄","15416541536");
        Address address2 = new Address("广州外语外贸大学5栋 611","王泓瑄","15416541536");
        Address address3 = new Address("华南理工大学大学城校区c6 344","王泓瑄","15416541536");
        addressesData.add(address1);
        addressesData.add(address2);
        addressesData.add(address3);

        addresses.setAdapter(new AddressAdapter(this, addressesData));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
