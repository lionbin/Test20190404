package com.sxzy.b.test_app.Test_03;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sxzy.b.test_app.R;

import java.util.ArrayList;
import java.util.List;

public class Test_03 extends AppCompatActivity {
    private ViewPager vp;
    private List<Fragment> fragmentList;
    private List<String> list;
    private TabLayout Tab_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_03);
        initView();
        initDate();
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        Tab_Layout.setupWithViewPager(vp);
    }


    private void initDate() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fm_t3_01());
        fragmentList.add(new Fm_t3_02());
        fragmentList.add(new Fm_t3_03());

        list = new ArrayList<>();
        list.add("标签一");
        list.add("标签二");
        list.add("标签三");

    }

    private void initView() {
        vp = findViewById(R.id.vp);
        Tab_Layout=findViewById(R.id.Tab_Layout);
    }
}
