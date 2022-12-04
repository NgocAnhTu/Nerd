package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nerd.databinding.ActivityPaymentsBinding;

public class payments extends AppCompatActivity {


    ActivityPaymentsBinding binding;
    RadioGroup radioGroupPayments;
    RadioButton radATM, radVisa, radMomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_payments);

        binding = ActivityPaymentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();

//        radioGroupPayments =(RadioGroup) findViewById(R.id.radg_Option);
//
//
//        radioGroupPayments.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                switch (i){
//                    case R.id.rad_ATM:
//                        Toast.makeText(payments.this, "Thẻ ATM nội địa", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.rad_Visa:
//                        Toast.makeText(payments.this, "Thẻ Visa", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.rad_Momo:
//                        Toast.makeText(payments.this, "Ví điện tử Momo", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
    }

    private void addEvents() {
        binding.radATM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(payments.this, "Thẻ ATM nội địa", Toast.LENGTH_SHORT).show();
            }
        });
        binding.radVisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(payments.this, "Thẻ Visa", Toast.LENGTH_SHORT).show();
            }
        });
        binding.radMomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(payments.this, "Ví điện tử Momo", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(payments.this, "Cảm ơn bạn đã đồng hành cùng Nerd!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(payments.this, ThanhToanThanhCong.class);
                startActivity(intent);
            }
        });
    }
}