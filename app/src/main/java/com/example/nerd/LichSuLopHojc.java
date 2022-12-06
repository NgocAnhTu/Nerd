package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LichSuLopHojc extends AppCompatActivity {
    Button btnFeedback;
    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_lop_hojc);

        btnFeedback = findViewById(R.id.btnFeedback);
        imbBack = findViewById(R.id.imbBack);


        btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LichSuLopHojc.this, LichSuLopHoc_feedback.class);
                startActivity(intent);
            }
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}