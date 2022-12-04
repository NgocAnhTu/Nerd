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
    TextView txtName;
    String name;
    ImageView imvavatar;
    ImageButton imbCourse1;
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
        imbCourse1 = findViewById(R.id.imbCourse1);
        imvavatar = findViewById(R.id.imv_avatar);
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
    }


}