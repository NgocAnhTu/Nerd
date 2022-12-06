package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.nerd.databinding.ActivityThiTiengAnhBinding;

public class ThiTiengAnh extends AppCompatActivity {

    ActivityThiTiengAnhBinding binding;

    TextView toeic, ielts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_thi_tieng_anh);


        binding = ActivityThiTiengAnhBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvent();

        toeic = findViewById(R.id.txt_Toeic);
        ielts = findViewById(R.id.txt_Ielts);

        toeic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://iigvietnam.com/bai-thi-toeic/");
            }
        });

        ielts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.britishcouncil.vn/thi/ielts/dang-ky-thi");
            }
        });
    }

    private void addEvent() {

        binding.imbtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ThiTiengAnh.this, dangkythi.class);
                startActivity(intent);

            }
        });

    }
    private void goLink(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}