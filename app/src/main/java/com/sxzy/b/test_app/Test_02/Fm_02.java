package com.sxzy.b.test_app.Test_02;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxzy.b.test_app.R;

public class Fm_02 extends Fragment {
    private TextView tv_show_02;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_fm02,null);
        tv_show_02=view.findViewById(R.id.tv_show_02);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_show_02.setText("我是界面二");
    }
}
