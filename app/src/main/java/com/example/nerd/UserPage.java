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

public class UserPage extends AppCompatActivity {

    ImageView imvAvatar;
    ImageButton imbCamera;
    TextView txtUserName;
    Button btnThongtincanhan, btnQuydinhlophoc, btnDieukhoan, btnLienhe, btnPhanhoi, btnCaidat;
    String username = General.Us.getUsername();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        linkViews();
        bottomNav();
        showInfo();
        setEvents();
    }

    private void linkViews() {
        txtUserName = findViewById(R.id.txtUserName);
        imvAvatar = findViewById(R.id.imvAvatar);
        imbCamera = findViewById(R.id.imbCamera);
        btnThongtincanhan = findViewById(R.id.btn_thongtincanhan);
        btnQuydinhlophoc = findViewById(R.id.btn_quydinhlophoc);
        btnDieukhoan = findViewById(R.id.btn_dieukhoan);
        btnLienhe = findViewById(R.id.btn_Lienhe);
        btnPhanhoi = findViewById(R.id.btn_Phanhoi);
        btnCaidat = findViewById(R.id.btn_Caidat);
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

    private void showInfo() {
        byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        imvAvatar.setImageBitmap(bitmap);
        txtUserName.setText(General.ADB.ShowInfo(username).getString(3));
    }

    private void setEvents() {
        btnThongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, UserInfo.class);
                startActivity(intent);
            }
        });

        btnQuydinhlophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, Quydinhlophoc.class);
                startActivity(intent);
            }
        });

        btnDieukhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, Dieukhoan.class);
                startActivity(intent);
            }
        });

        btnLienhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, Lienhe.class);
                startActivity(intent);
            }
        });

        btnPhanhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, Phanhoi.class);
                startActivity(intent);
            }
        });

        btnCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserPage.this, Setting.class);
                startActivity(intent);
            }
        });
    }
}