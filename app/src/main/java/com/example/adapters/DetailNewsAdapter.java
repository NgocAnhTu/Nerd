package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MDNews;
import com.example.nerd.R;

import java.util.List;

public class DetailNewsAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<MDNews> detailnews;

    public DetailNewsAdapter(Activity activity, int item_layout, List<MDNews> detailnews) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.detailnews = detailnews;
    }
    @Override
    public int getCount() {
        return detailnews.size();
    }

    @Override
    public Object getItem(int i) {
        return detailnews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        DetailNewsAdapter.ViewHolder holder;
        if (view==null) {
            //Link views
            holder = new DetailNewsAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvdetailBlog = view.findViewById(R.id.imv_detailImg);
            holder.txtdetailTitle = view.findViewById(R.id.txt_Tittle);
            holder.txtdetailDate_name = view.findViewById(R.id.txt_detailDate_name);
            holder.txtdetailContent = view.findViewById(R.id.txt_detailContent);

            view.setTag(holder);

        } else {
            holder =(DetailNewsAdapter.ViewHolder) view.getTag();
        }
        MDNews n = detailnews.get(i);
        holder.imvdetailBlog.setImageResource(n.getDetailThump());
        holder.txtdetailTitle.setText(n.getDetailTittle());
        holder.txtdetailDate_name.setText(n.getDetailDate_Name());
        holder.txtdetailContent.setText(n.getDetailContent());

        return view;
    }
    public static class  ViewHolder {
        ImageView imvdetailBlog;
        TextView txtdetailTitle,txtdetailDate_name, txtdetailContent;
    }
}

