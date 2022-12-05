package com.example.gvAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.model.Teacher;
import com.example.nerd.R;

import java.util.List;

public class GVAdapter extends BaseAdapter {
    Activity context;
    int item;
    List<Teacher> teachers;

    public GVAdapter(Activity context, int item, List<Teacher> teachers) {
        this.context = context;
        this.item = item;
        this.teachers = teachers;
    }

    @Override
    public int getCount() {
        return teachers.size();
    }

    @Override
    public Object getItem(int i) {
        return teachers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder ;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item,null);
            holder.imvAva = view.findViewById(R.id.img_gv);

            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        Teacher teacher = teachers.get(i);
        holder.imvAva.setImageResource(teacher.getAva());

        return view;
    }
    public class ViewHolder {
        ImageView imvAva;



    }
}
