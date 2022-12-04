package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adapters.DetailNewsAdapter;
import com.example.adapters.NewsAdapter;
import com.example.model.MDNews;
import com.example.model.MNews;
import com.example.nerd.databinding.ActivityChitietblogBinding;

import java.util.ArrayList;

public class chitietblog extends AppCompatActivity {
    ListView lvDetailNews;
    ActivityChitietblogBinding binding;
    DetailNewsAdapter detailadapter;
    ArrayList<MDNews> newsDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        binding = ActivityChitietblogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkview();
        loadData();
        setEvents();
    }

    private void linkview() {

        lvDetailNews = findViewById(R.id.lv_DetailNews);
    }


    private void setEvents() {
        lvDetailNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(chitietblog.this, Blog.class);
                intent.putExtra("thongtinsanpham", newsDetailList.get(i));
                startActivity(intent);
            }
        });

    }

    private void loadData() {
        newsDetailList = new ArrayList<>();
        newsDetailList.add(new MDNews(R.drawable.nerd17,"Học 100 từ tiếng anh trong 15 phút", "28 Nov 20222 | by Ngoc Anh Tu", "Học từ vựng tiếng Anh mỗi ngày cùng ứng d"));
        newsDetailList.add(new MDNews(R.drawable.nerd5,"Học 100 từ tiếng anh trong 15 phút", "28 Nov 20222 | by Ngoc Anh Tu", "Học từ vựng tiếng Anh mỗi ngày cùng ứng d"));
        newsDetailList.add(new MDNews(R.drawable.nerd17,"Học 100 từ tiếng anh trong 15 phút", "28 Nov 20222 | by Ngoc Anh Tu", "Học từ vựng tiếng Anh mỗi ngày cùng ứng d"));
        newsDetailList.add(new MDNews(R.drawable.nerd5,"Học 100 từ tiếng anh trong 15 phút", "28 Nov 20222 | by Ngoc Anh Tu", "Học từ vựng tiếng Anh mỗi ngày cùng ứng d"));
        newsDetailList.add(new MDNews(R.drawable.nerd17,"Học 100 từ tiếng anh trong 15 phút", "28 Nov 20222 | by Ngoc Anh Tu", "Học từ vựng tiếng Anh mỗi ngày cùng ứng d"));

        //Init apdater
        detailadapter = new DetailNewsAdapter(chitietblog.this, R.layout.activity_item_list, newsDetailList);
        binding.lvDetailNews.setAdapter(detailadapter);
//
    }

}