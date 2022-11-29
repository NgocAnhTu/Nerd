package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adapters.NewsAdapter;
import com.example.model.MNews;
import com.example.nerd.databinding.ActivityNewsBinding;

import java.util.ArrayList;

public class news extends AppCompatActivity {
    ListView lvNews;
    ActivityNewsBinding binding;
    NewsAdapter adapter;
    ArrayList<MNews> newsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        binding = ActivityNewsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        linkview();
        loadData();
        setEvents();
    }

    private void loadData() {
        newsList = new ArrayList<>();
        newsList.add(new MNews(R.drawable.blog,"hhihihi", "hhihihi" ));
        newsList.add(new MNews(R.drawable.blog,"HaNoi",  "hhihihi"));
        newsList.add(new MNews(R.drawable.blog,"Sài Gòn", "hhihihi"));
        newsList.add(new MNews(R.drawable.blog,"Bia 333", "hhihihi"));
        newsList.add(new MNews(R.drawable.blog,"Sapporo", "hhihihi"));

        //Init apdater
        adapter = new NewsAdapter(news.this, R.layout.activity_item_list, newsList);
        binding.lvNews.setAdapter(adapter);
    }

    private void setEvents() {
//        imbBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(news.this, Blog.class);
                startActivity(intent);
            }
        });
    }

    private void linkview() {
        lvNews = findViewById(R.id.lv_News);
//        imbBack = findViewById(R.id.imbBack);
//        rcvGVNoiBat =findViewById(R.id.rcvGVNoiBat);
//        grvGVNormal = findViewById(R.id.grvGVNormal);
    }
}