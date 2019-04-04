package com.sxzy.b.test_app.Test_06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.sxzy.b.test_app.R;

import java.util.ArrayList;
import java.util.List;

public class Grid_Activity01 extends AppCompatActivity {
    private GridView Gv;
    private List<Emty> list;
    private int[]im = new int[]{R.drawable.main_back, R.drawable.tab_focus, R.drawable.tab_local,
            R.drawable.tab_news, R.drawable.tab_pics, R.drawable.tab_read, R.drawable.tab_ties,
            R.drawable.tab_ugc, R.drawable.tab_vote};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initView();
        initDate();
        Gv.setAdapter(new Grid_adapter(list, this));
    }

    private void initDate() {
        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Emty("名" + i, im[i]));
        }
    }

    private void initView() {
        Gv = findViewById(R.id.gridview);
    }
}
