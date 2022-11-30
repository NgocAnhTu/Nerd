package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Phanhoi extends AppCompatActivity {

    ImageView imvBack;
    Button btnKhaosat, btnYkienkhac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phanhoi);

        setEvent();
        bottomNav();
        linkViews();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imv_back);
        btnKhaosat = findViewById(R.id.btn_Khaosat);
        btnYkienkhac = findViewById(R.id.btn_Ykienkhac);
    }

    private void setEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnKhaosat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Phanhoi.this, Khaosat.class);
                startActivity(intent);
            }
        });

        btnYkienkhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Phanhoi.this, Ykienkhac.class);
                startActivity(intent);
            }
        });
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Homepage);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Homepage:
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(),Courses.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(), lichhoc.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),UserPage.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}