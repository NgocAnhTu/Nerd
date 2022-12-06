package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Lichsulophoc;
import com.example.nerd.R;

import java.util.ArrayList;

public class ItemBuoiHocAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Lichsulophoc> lichsulophocs;

    public ItemBuoiHocAdapter(Activity context, ArrayList<Lichsulophoc> lichsulophocs){
        this.context = context;
        this.lichsulophocs = lichsulophocs;
    }

    @Override
    public int getCount() {
        return lichsulophocs.size();
    }

    @Override
    public Object getItem(int i) {
        return lichsulophocs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //Link item view
            holder = new ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.itemlist_lichsulophoc, null);
            holder.txtTenbaihoc = view.findViewById(R.id.txtTenbaihoc);
            holder.txtGio= view.findViewById(R.id.txtGio);
            holder.txtNgay = view.findViewById(R.id.txtNgay);
            holder.txtNameGV = view.findViewById(R.id.txtNameGV);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Lichsulophoc l = lichsulophocs.get(i);
        holder.txtNgay.setText(l.getNgay());
        holder.txtGio.setText(l.getGio());
        holder.txtTenbaihoc.setText(l.getTenbaihoc());
        holder.txtNameGV.setText(l.getNameGV());

        return view;
    }
    public static class ViewHolder{
        private TextView txtTenbaihoc, txtGio, txtNgay, txtNameGV;

    }
}
