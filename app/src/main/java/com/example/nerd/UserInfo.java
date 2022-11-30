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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserInfo extends AppCompatActivity {

    ImageView imvAvatar, imvBack;
    TextView txtUserName;
    EditText edtFullName, edtEmail, edtPhoneNumb, edtBirthDay;
    Button btnUpdateUserInfo;
    String username = General.Us.getUsername();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        linkViews();
        showInfo();
        setEvents();
        bottomNav();
    }

    private void linkViews() {
        imvAvatar = findViewById(R.id.imvAvatar);
        imvBack = findViewById(R.id.imv_back);
        txtUserName = findViewById(R.id.txtUserName);
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edt_email);
        edtPhoneNumb = findViewById(R.id.edtPhoneNumb);
        edtBirthDay = findViewById(R.id.edtBirthDay);
        btnUpdateUserInfo = findViewById(R.id.btnUpdateUserInFo);
    }

    private void showInfo() {
        byte[] photo = General.ADB.ShowInfo(username).getBlob(7);
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0, photo.length);
        imvAvatar.setImageBitmap(bitmap);
        txtUserName.setText(General.ADB.ShowInfo(username).getString(1));
        edtFullName.setText(General.ADB.ShowInfo(username).getString(3));
        edtPhoneNumb.setText(General.ADB.ShowInfo(username).getString(4));
        edtEmail.setText(General.ADB.ShowInfo(username).getString(5));
        edtBirthDay.setText(General.ADB.ShowInfo(username).getString(6));
    }

    private void setEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdateUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldEmail = General.ADB.ShowInfo(username).getString(5);
                String oldPhone = General.ADB.ShowInfo(username).getString(4);
                String name = edtFullName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String phoneS = edtPhoneNumb.getText().toString();
                int phone = Integer.parseInt(phoneS);
                String birth = edtBirthDay.getText().toString();
                if (name.equals("") || email.equals("") ||phoneS.equals("")||birth.equals("")){
                    Toast.makeText(UserInfo.this, "Vui lòng điền đủ các ô thông tin!", Toast.LENGTH_SHORT).show();
                }else{
                    if (General.ADB.checkEmail(email)&& !email.equals(oldEmail)){
                        Toast.makeText(UserInfo.this, "Email đã có người sử dụng!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (General.ADB.checkPhone(phoneS)&& !phoneS.equals(oldPhone)){
                            Toast.makeText(UserInfo.this, "Số điện thoại đã có người sử dụng", Toast.LENGTH_SHORT).show();
                        }else {
                            General.ADB.updateName(username, name);
                            General.ADB.updateEmail(username, email);
                            General.ADB.updatePhone(username, phone);
                            General.ADB.updateBirth(username, birth);
                            Toast.makeText(UserInfo.this, "Cập nhật thông tin thành công!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UserInfo.this, UserPage.class);
                            startActivity(intent);
                        }
                    }
                }
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