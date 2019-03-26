package com.sxzy.b.test_app.Test_05;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sxzy.b.test_app.R;

import java.util.ArrayList;
import java.util.List;


public class List_View extends AppCompatActivity {
    private ListView listView;
    private List<Student> list_stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        initData();
        listView.setAdapter(new List_adapter(list_stu, this));
    }

    private void initData() {
        list_stu = new ArrayList<>();
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
        list_stu.add(new Student("qq", "qq", 18));
    }

    private void initView() {
        listView = findViewById(R.id.list_view);
    }
}
