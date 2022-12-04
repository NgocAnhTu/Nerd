package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nerd.databinding.ActivityDangKyThiBinding;

public class dangkythi extends AppCompatActivity {

    ActivityDangKyThiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dang_ky_thi);

        binding = ActivityDangKyThiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvent();
    }

    private void addEvent() {

        binding.imbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangkythi.this, homepage.class);
                startActivity(intent);
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(dangkythi.this, ThiTiengAnh.class);
                startActivity(intent);

            }
        });
    }
}