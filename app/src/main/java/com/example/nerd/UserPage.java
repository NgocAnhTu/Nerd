package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firebase.ReadWriteUserDetails;
import com.example.utils.General;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class UserPage extends AppCompatActivity {

    ImageView imvAvatar;
    ImageButton imbCamera;
    TextView txtName, txtEmail, txtPhone, txtDOB;
    Button btnThongtincanhan, btnQuydinhlophoc, btnDieukhoan, btnLienhe, btnPhanhoi, btnCaidat;
    FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        linkViews();
        bottomNav();
        setEvents();

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if(firebaseUser != null) {
            showInfo(firebaseUser);
        }
    }

    private void showInfo(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();
        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Users");
        referenceProfile.child(userID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteUserDetails readUserDetails = snapshot.getValue(ReadWriteUserDetails.class);
                if(readUserDetails != null){
                    txtName.setText(readUserDetails.name);
                    txtEmail.setText(firebaseUser.getEmail());
                    txtDOB.setText(readUserDetails.doB);
                    txtPhone.setText(readUserDetails.phone);

                    Uri uri = firebaseUser.getPhotoUrl();
                    Picasso.get().load(uri).into(imvAvatar);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void linkViews() {
        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);
        txtPhone = findViewById(R.id.txtPhone);
        txtDOB = findViewById(R.id.txtDOB);
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
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Homepage:
                        startActivity(new Intent(getApplicationContext(), homepage.class));
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(), Courses.class));
                        return true;
                    case R.id.calendar:
                        startActivity(new Intent(getApplicationContext(), Calendar.class));
                        Intent user = new Intent(UserPage.this, lichhoc.class);
                        startActivity(user);
                        return true;
                    case R.id.user:
                }
                return false;
            }
        });
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