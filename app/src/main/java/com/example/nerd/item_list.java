package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.DetailNewsAdapter;
import com.example.adapters.NewsAdapter;
import com.example.model.MDNews;
import com.example.model.MNews;
import com.example.nerd.databinding.ActivityItemListBinding;
import com.example.nerd.databinding.ActivityNewsBinding;

import java.util.ArrayList;

public class item_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
    }
}