package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class UserPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        bottomNav();
    }
    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Homepage:
                        Intent courses = new Intent(UserPage.this, homepage.class);
                        startActivity(courses);
                        return true;

                    case R.id.user:
                        return true;

                    case R.id.calendar:
                        Intent user = new Intent(UserPage.this, Calendar.class);
                        startActivity(user);
                        return true;
                    case R.id.courses:
                        Intent calendar = new Intent(UserPage.this, lichhoc.class);
                        startActivity(calendar);
                        return true;
                }

                return false;
            }
        });

    }
}