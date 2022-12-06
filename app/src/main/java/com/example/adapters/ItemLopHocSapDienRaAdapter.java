package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Lophocsapdienra;
import com.example.nerd.R;

import java.util.ArrayList;

public class ItemLopHocSapDienRaAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Lophocsapdienra> lopHocSapDienRas;

    public ItemLopHocSapDienRaAdapter(Activity context, ArrayList<Lophocsapdienra> lopHocSapDienRas) {
        this.context = context;
        this.lopHocSapDienRas = lopHocSapDienRas;
    }

    @Override
    public int getCount() {
        return lopHocSapDienRas.size();
    }

    @Override
    public Object getItem(int i) {
        return lopHocSapDienRas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemLopHocSapDienRaAdapter.ViewHolder holder;
        if(view == null){
            //Link item view
            holder = new ItemLopHocSapDienRaAdapter.ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.itemlist_lophocsapdienra, null);
            holder.txtTenbaihoc = view.findViewById(R.id.txtTenbaihoc1);
            holder.txtGio= view.findViewById(R.id.txtGio1);
            holder.txtNgay = view.findViewById(R.id.txtNgay1);
            holder.txtNameGV = view.findViewById(R.id.txtNameGV1);
            holder.txtSoLuonghv = view.findViewById(R.id.txtSoLuonghv);
            view.setTag(holder);
        }else {
            holder = (ItemLopHocSapDienRaAdapter.ViewHolder) view.getTag();

        }

        Lophocsapdienra l = lopHocSapDienRas.get(i);
        holder.txtNgay.setText(l.getNgay());
        holder.txtGio.setText(l.getGio());
        holder.txtTenbaihoc.setText(l.getTenbaihoc());
        holder.txtNameGV.setText(l.getNameGV());
        holder.txtSoLuonghv.setText(l.getSoLuonghv());
        return view;
    }
    public static class ViewHolder{
        private TextView txtTenbaihoc, txtGio, txtNgay, txtNameGV, txtSoLuonghv;

    }

}
