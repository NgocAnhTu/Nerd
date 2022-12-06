package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class Feedback1 extends AppCompatActivity {

    Button btnKhaosat;
    Button btnYkien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback1);
        bottomNav();

        btnKhaosat = findViewById(R.id.btnKhaosat);
        btnKhaosat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ks = new Intent(Feedback1.this, Feedback.class);
                startActivity(ks);
            }
        });

        btnYkien = findViewById(R.id.btnYkien);
        btnYkien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yk = new Intent(Feedback1.this, Feedback2.class);
                startActivity(yk);
            }
        });

    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Homepage:
                        Intent courses = new Intent(Feedback1.this, homepage.class);
                        startActivity(courses);
                        return true;

                    case R.id.user:
                        return true;

                    case R.id.calendar:
                        Intent user = new Intent(Feedback1.this, lichhoc.class);
                        startActivity(user);
                        return true;
                    case R.id.courses:
                        Intent calendar = new Intent(Feedback1.this, Courses.class);
                        startActivity(calendar);
                        return true;
                }

                return false;
            }
        });
    }
}