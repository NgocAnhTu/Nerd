package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nerd.databinding.ActivityThanhToanThanhCongBinding;

public class ThanhToanThanhCong extends AppCompatActivity {

    ActivityThanhToanThanhCongBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_thanh_cong);

        binding = ActivityThanhToanThanhCongBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvent();
    }

    private void addEvent() {
        binding.imbtnDetailedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToanThanhCong.this, Detailed_Payment.class);
                startActivity(intent);
            }
        });
    }
}