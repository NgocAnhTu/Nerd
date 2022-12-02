package com.example.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MNews;
import com.example.nerd.R;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<MNews> news;

    public NewsAdapter(Activity activity, int item_layout, List<MNews> news) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.news = news;
    }
    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int i) {
        return news.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null) {
            //Link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvImage = view.findViewById(R.id.imv_Image);
            holder.txtTittle = view.findViewById(R.id.txt_Tittle);

            view.setTag(holder);

        } else {
            holder =(ViewHolder) view.getTag();
        }

        MNews n = news.get(i);
        holder.imvImage.setImageResource(n.getThump());
        holder.txtTittle.setText(n.getTittle());

        return view;
    }
    public static class  ViewHolder {
        ImageView imvImage;
        TextView txtTittle;
    }
}
