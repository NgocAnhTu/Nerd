package com.example.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Notifications;
import com.example.nerd.R;

import java.util.ArrayList;

public class ItemNotificationAdapter extends BaseAdapter {
    private Activity context;
    ArrayList<Notifications> notifications;

    public ItemNotificationAdapter(Activity context, ArrayList<Notifications> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @Override
    public int getCount() {
        return notifications.size();
    }

    @Override
    public Object getItem(int i) {
        return notifications.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ItemNotificationAdapter.ViewHolder();
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.item_notification, null);
            holder.txtNotification = view.findViewById(R.id.txt_Notification);
            view.setTag(holder);
        }else {
            holder = (ItemNotificationAdapter.ViewHolder) view.getTag();

        }
        holder.txtNotification.setText(notifications.get(i).getNotifications());
        return view;
    }
    public static class ViewHolder {
        TextView txtNotification;
    }
}