package com.sxzy.b.test_app.Test_05;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.TextView;

import com.sxzy.b.test_app.R;

import java.util.List;

public class List_adapter extends BaseAdapter {
    List<Student> list;
    Context context;

    public List_adapter(List<Student> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list, null);
        }
        TextView name = convertView.findViewById(R.id.tv_name);
        TextView banji = convertView.findViewById(R.id.tv_banji);
        TextView age = convertView.findViewById(R.id.tv_age);
        Student student=list.get(position);
        name.setText(student.getName());
        banji.setText(student.getBanji());
        age.setText(student.getSge()+"");
        return convertView;
    }
}
