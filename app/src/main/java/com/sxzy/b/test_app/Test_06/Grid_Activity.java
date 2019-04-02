package com.sxzy.b.test_app.Test_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.sxzy.b.test_app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid_Activity extends AppCompatActivity {
    private GridView Gv;
    private List<Map<String,Object>> list;
    private int[]im = new int[]{R.drawable.main_back, R.drawable.tab_focus, R.drawable.tab_local,
            R.drawable.tab_news, R.drawable.tab_pics, R.drawable.tab_read, R.drawable.tab_ties,
            R.drawable.tab_ugc, R.drawable.tab_vote};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initView();
        initDate();
        Gv.setAdapter(new Grid_adapter01(list, this));
    }

    private void initDate() {
        list = new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put("name","名"+i);
            map.put("img",im[i]);
            list.add(map);
        }
    }

    private void initView() {
        Gv = findViewById(R.id.gridview);
    }
}
