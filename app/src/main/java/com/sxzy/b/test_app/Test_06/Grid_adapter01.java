package com.sxzy.b.test_app.Test_06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sxzy.b.test_app.R;

import java.util.List;
import java.util.Map;

public class Grid_adapter01 extends BaseAdapter {
    private  List<Map<String,Object>> list;
    private Context context;

    public Grid_adapter01(List<Map<String, Object>> list, Context context) {
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
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_grid,null);
        }
        ImageView imageView=convertView.findViewById(R.id.imv);
        TextView textView=convertView.findViewById(R.id.tv_name);
        imageView.setImageResource((Integer) list.get(position).get("img"));
        textView.setText((String)(list.get(position).get("name")));
        return convertView;
    }
}
