package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nerd.databinding.ActivityKhoahocchitietBinding;

public class khoahocchitiet extends AppCompatActivity {

    ActivityKhoahocchitietBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoahocchitiet);

        Button btnTTKH = findViewById(R.id.btn_ThanhtoanKhoahoc);

        btnTTKH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(khoahocchitiet.this, payments.class);
                startActivity(intent);
            }
        });
    }
}