package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LichSuLopHoc_feedback extends AppCompatActivity {

    Button btnSendFeedback;
    ImageButton imbBack;
    EditText edtfb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_lop_hoc_feedback);

        btnSendFeedback = findViewById(R.id.btnSendFeedback);
        imbBack = findViewById(R.id.imbBack);
        edtfb = findViewById(R.id.edtNhanXetCuaHV);
        btnSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtfb.setText("");
                Toast.makeText(LichSuLopHoc_feedback.this, "Hệ thống đã tiếp nhận Feedback của bạn", Toast.LENGTH_SHORT).show();
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