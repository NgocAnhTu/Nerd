package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        bottomNav();
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.courses);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Homepage:
                        Intent courses = new Intent(Courses.this, homepage.class);
                        startActivity(courses);
                        return true;

                    case R.id.courses:
                        return true;

                    case R.id.user:
                        Intent user = new Intent(Courses.this, UserPage.class);
                        startActivity(user);
                        return true;
                    case R.id.calendar:
                        Intent calendar = new Intent(Courses.this, lichhoc.class);
                        startActivity(calendar);
                        return true;
                }

                return false;
            }
        });

    }
}