package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Setting extends AppCompatActivity {

    ImageView imvBack;
    Button btnDoimaukhau, btnThongbao, btnNgonngu, btnDangxuat, btnConfirm, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        linkViews();
        bottomNav();
        setEvents();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imv_back);
        btnDoimaukhau = findViewById(R.id.btn_doimatkhau);
        btnThongbao = findViewById(R.id.btn_Thongbao);
        btnDangxuat = findViewById(R.id.btn_Dangxuat);
    }

    private void setEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnDoimaukhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, ForgotPass.class);
                startActivity(intent);
            }
        });

        btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Setting.this);
                dialog.setContentView(R.layout.logout_dialog);
                dialog.setCanceledOnTouchOutside(false);
                btnConfirm = dialog.findViewById(R.id.btn_Confirm);
                btnCancel = dialog.findViewById(R.id.btn_Cancel);

                btnConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Setting.this,Login.class);
                        startActivity(intent);
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

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