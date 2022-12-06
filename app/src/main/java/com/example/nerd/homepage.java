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

public class homepage extends AppCompatActivity {
    TextView txtName, txtGhiChu, txtBaiTap, txtDangKyThi;
    String name;
    ImageView imvavatar,imbBlog1, ibNoti, imbBlog2, imbBlog3;
    ImageButton imbCourse1, imbGV1, imbGV2, imbGV3;
    Button btnSee ,btnSeeAllGV;
    FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        linkViews();
        bottomNav();
        changePage();

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
                    name = readUserDetails.name;
                    txtName.setText(name);
                    Uri uri = firebaseUser.getPhotoUrl();
                    Picasso.get().load(uri).into(imvavatar);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void linkViews() {
        txtName = findViewById(R.id.txt_Name);
        txtGhiChu = findViewById(R.id.txt_ghichu);
        txtBaiTap = findViewById(R.id.txt_baitap);
        txtDangKyThi = findViewById(R.id.txt_dangkithi);
        imbCourse1 = findViewById(R.id.imbCourse1);
        imvavatar = findViewById(R.id.imv_avatar);
        imbBlog1 = findViewById(R.id.imb_Blog1);
        imbBlog2 = findViewById(R.id.imb_Blog2);
        imbBlog3 = findViewById(R.id.imb_Blog3);
        btnSee = findViewById(R.id.btn_See);
        btnSeeAllGV = findViewById(R.id.btn_SeeAllGV);
        ibNoti = findViewById(R.id.ib_Noti);
        imbGV1 = findViewById(R.id.imb_gv1);
        imbGV2 = findViewById(R.id.imb_gv2);
        imbGV3 = findViewById(R.id.imb_gv3);
    }

    private void bottomNav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.Homepage);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.courses:
                        startActivity( new Intent(homepage.this, Courses.class));
                        return true;
                    case R.id.Homepage:
                        return true;
                    case R.id.user:
                        startActivity(new Intent(homepage.this, UserPage.class));
                        return true;
                    case R.id.calendar:
                        startActivity(new Intent(homepage.this, lichhoc.class));
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
                Intent intent = new Intent(homepage.this, Blog.class);
                startActivity(intent);
            }
        });

        imbBlog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, Blog.class);
                startActivity(intent);
            }
        });

        imbBlog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, Blog.class);
                startActivity(intent);
            }
        });

        btnSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent all = new Intent(homepage.this, news.class);
                startActivity(all);
            }
        });

        btnSeeAllGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent see = new Intent(homepage.this, GiaoVien.class);
                startActivity(see);
            }
        });
        ibNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent noti = new Intent(homepage.this, Notification.class);
                startActivity(noti);
            }
        });
        imbGV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gv1 = new Intent(homepage.this, DetailsGV.class);
                startActivity(gv1);
            }
        });
        imbGV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gv2 = new Intent(homepage.this, DetailGV1.class);
                startActivity(gv2);
            }
        });
        imbGV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gv3 = new Intent(homepage.this, DetailGV2.class);
                startActivity(gv3);
            }
        });

        txtGhiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, Ghichu.class);
                startActivity(intent);
            }
        });

        txtBaiTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, Assignments_Nerd.class);
                startActivity(intent);
            }
        });

        txtDangKyThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(homepage.this, dangkythi.class);
                startActivity(intent);
            }
        });
    }
}