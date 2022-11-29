package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homepage extends AppCompatActivity {
    TextView txtName;
    String username = General.Us.getUsername();
    ImageView imvavatar;
    ImageButton imbCourse1, imbBlog1, imbBlog2, imbBlog3 ;
    Button btnAllBlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        linkViews();
        showInfo();
        bottomNav();
        changePage();

    }

    private void linkViews() {
        txtName = findViewById(R.id.txt_Name);
        imbCourse1 = findViewById(R.id.imbCourse1);
        imvavatar = findViewById(R.id.imv_avatar);
        imbBlog1 = findViewById(R.id.imb_Blog1);
        imbBlog2 = findViewById(R.id.imb_Blog2);
        imbBlog3 = findViewById(R.id.imb_Blog3);
        btnAllBlog = findViewById(R.id.btn_allBlog);
    }


    private void showInfo() {

        txtName.setText(General.ADB.ShowInfo(username).getString(3));
        //convert photo
        byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo,0,photo.length);
        imvavatar.setImageBitmap(bitmap);

    }


    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Homepage);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.courses:
                        Intent courses = new Intent(homepage.this, Courses.class);
                        startActivity(courses);
                        return true;

                    case R.id.Homepage:
                        return true;

                    case R.id.user:
                        Intent user = new Intent(homepage.this, UserPage.class);
                        startActivity(user);
                        return true;
                    case R.id.calendar:
                        Intent calendar = new Intent(homepage.this, lichhoc.class);
                        startActivity(calendar);
                        return true;
                }

                return false;
            }
        });

    }
    private void changePage() {

        imbCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent course1 = new Intent(homepage.this, khoahocchitiet.class);
                startActivity(course1);
            }
        });

        imbBlog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog1 = new Intent(homepage.this, Blog.class);
                startActivity(blog1);
            }
        });
        imbBlog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog2 = new Intent(homepage.this, Blog.class);
                startActivity(blog2);
            }
        });
        imbBlog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent blog3 = new Intent(homepage.this, Blog.class);
                startActivity(blog3);
            }
        });
            btnAllBlog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent allBlog = new Intent(homepage.this, news.class);
                    startActivity(allBlog);
                }
            });
        }
        


}