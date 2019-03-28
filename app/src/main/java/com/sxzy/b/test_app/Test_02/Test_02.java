package com.sxzy.b.test_app.Test_02;

//dcx zZ...

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sxzy.b.test_app.R;

import java.util.ArrayList;
import java.util.List;

public class Test_02 extends AppCompatActivity {

    private FrameLayout fl;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_03;
    private RadioButton rb_04;
    private RadioGroup rg;
 FragmentTransaction fragmentTransaction;
    private List<Fragment> list;
    int pos = 0;
    private Fragment fmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_02);
        initView();
        initDate();
        rg.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg.check(R.id.rb_01);
    }

    private class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_01:
                    pos = 0;
                    break;

                case R.id.rb_02:
                    pos = 1;
                    break;

                case R.id.rb_03:
                    pos = 2;
                    break;

                case R.id.rb_04:
                    pos = 3;
                    break;
            }
            switchFragment(fmt, list.get(pos));
        }
    }


    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            fmt = to;
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                if (from!= null) {
                    fragmentTransaction.hide(from);
                }
                if (to!= null) {
                    fragmentTransaction.add(R.id.fl, to).commit();
                }
            } else {
                if (from != null) {
                    fragmentTransaction.hide(from);
                }
                if (to != null) {
                    fragmentTransaction.show(to).commit();
                }
            }
        }

    }

    private void initDate() {
        list = new ArrayList<>();
        list.add(new Fm_01());
        list.add(new Fm_02());
        list.add(new Fm_03());
        list.add(new Fm_04());
    }

    private void initView() {
        fl = findViewById(R.id.fl);
        rb_01 = findViewById(R.id.rb_01);
        rb_02 = findViewById(R.id.rb_02);
        rb_03 = findViewById(R.id.rb_03);
        rb_04 = findViewById(R.id.rb_04);
        rg = findViewById(R.id.rg);
    }
}
