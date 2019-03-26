package com.sxzy.b.test_app.Test_03;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sxzy.b.test_app.R;
import com.sxzy.b.test_app.Test_05.List_adapter;
import com.sxzy.b.test_app.Test_05.Student;

import java.util.ArrayList;
import java.util.List;

public class Fm_t3_03 extends Fragment {
    ListView listView;
    private List<Student> list_stu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.itrm_fm_t3_03, null);
listView=view.findViewById(R.id.lv_t03);
initData();
listView.setAdapter(new List_adapter(list_stu,getContext()));
        return view;

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
        list_stu.add(new Student("qq", "qq", 18));}
}
