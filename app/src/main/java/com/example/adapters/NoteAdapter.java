package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Note;
import com.example.nerd.Ghichu;
import com.example.nerd.R;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private Ghichu context;
    private int layout;
    private List<Note> noteList;

    public NoteAdapter(Ghichu context, int layout, List<Note> congViecList) {
        this.context = context;
        this.layout = layout;
        this.noteList = congViecList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        TextView tvTenCV;
        ImageView imgSua, imgXoa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            holder.tvTenCV = convertView.findViewById(com.example.nerd.R.id.tvTenCV);
            holder.imgSua = convertView.findViewById(R.id.imgSua);
            holder.imgXoa = convertView.findViewById(R.id.imgXoa);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Note congViec = noteList.get(position);

        holder.tvTenCV.setText(congViec.getTenCV());

        // sửa
        holder.imgSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogSuaCV(congViec.getTenCV(),congViec.getId());
            }
        });

        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.XoaCV(congViec.getTenCV(),congViec.getId());
            }
        });

        return convertView;
    }
}
