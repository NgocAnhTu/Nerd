package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebase.ReadWriteUserDetails;
import com.example.utils.General;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class UserInfo extends AppCompatActivity {

    ImageView imvAvatar, imvBack;
    TextView txtName;
    String textPhone, textDOB, textName;
    EditText edtName, edtEmail, edtPhone, edtDOB, edtConfirmPassword;
    Button btnUpdateUserInfo, btnOk, btnCancel;
    DatePickerDialog picker;
    FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        linkViews();
        setEvents();

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();
        if(firebaseUser != null) {
            showInfo(firebaseUser);
        }

        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(UserInfo.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
                        edtDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, day);
                picker.show();
            }
        });

        btnUpdateUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUserInfor(firebaseUser);
            }
        });
    }

    private void updateUserInfor(FirebaseUser firebaseUser) {
        if(edtPhone.getText().toString().length()!= 10) {
            edtPhone.setError("Số điện thoại bao gồm 10 chữ số");
            edtName.requestFocus();
        }else {
            textPhone = edtPhone.getText().toString();
            textDOB = edtDOB.getText().toString();
            textName = edtName.getText().toString();

            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textName, textDOB, textPhone);

            DatabaseReference referenceProfile = FirebaseDatabase
                    .getInstance("https://nerd-app-7a1e1-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .getReference("Users");

            String userID = firebaseUser.getUid();

            referenceProfile.child(userID)
                    .setValue(writeUserDetails)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setDisplayName(textName).build();
                        firebaseUser.updateProfile(profileUpdates);

                        Toast.makeText(UserInfo.this, "Cập nhật thông tin thành công",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(UserInfo.this, UserInfo.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private void linkViews() {
        imvAvatar = findViewById(R.id.imvAvatar);
        imvBack = findViewById(R.id.imv_back);
        txtName = findViewById(R.id.txtUserName);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtDOB = findViewById(R.id.edt_DOB);
        btnUpdateUserInfo = findViewById(R.id.btnUpdateUserInFo);
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

                    Uri uri = firebaseUser.getPhotoUrl();
                    Picasso.get().load(uri).into(imvAvatar);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void setEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfo.this, UserPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        imvAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfo.this, UploadAvatar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}