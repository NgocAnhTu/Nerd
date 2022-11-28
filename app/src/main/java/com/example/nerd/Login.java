package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.DatabaseHelper;
import com.example.model.Users;
import com.example.utils.General;

import java.io.ByteArrayOutputStream;

public class Login extends AppCompatActivity {

    Button btnLogin, btnRegister;
    EditText edtUsername, edtPassword;
    TextView txtForgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        General.ADB = new DatabaseHelper(this);
        General.Us = new Users();
        prepareDb();
        linkViews();
        getEvents();
        getData();

    }


    private void getEvents() {
        DatabaseHelper accountDataBase = new DatabaseHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangKy = new Intent(Login.this,Register.class);
                startActivity(intentDangKy);
            }
        });

        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quen = new Intent(Login.this, ForgotPass.class);
                startActivity(quen);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Lấy dữ liệu
                String userName = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                //Check dữ liệu
                boolean CheckUserPass = General.ADB.checkUsernamePassword(userName, password);
                boolean CheckEmailPass = General.ADB.checkEmailPassword(userName, password);
                boolean CheckPhonePass = General.ADB.checkPhonePassword(userName, password);
                if (CheckUserPass) {
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                    General.Us.setUsername(userName);
                    Intent truyenUserPage = new Intent(Login.this, homepage.class);
                    truyenUserPage.putExtra("UsernameFromDangNhap", userName);
                    startActivity(truyenUserPage);
                }else{
                    if (CheckEmailPass) {
                        Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                        String email = General.ADB.ChangeEmailtoUsername(userName);
                        General.Us.setUsername(email);

                        Intent truyenUserPage = new Intent(Login.this, homepage.class);
                        startActivity(truyenUserPage);
                    }else{
                        if (CheckPhonePass) {
                            Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                            String phone = General.ADB.ChangePhonetoUsername(userName);
                            General.Us.setUsername(phone);
                            Intent truyenUserPage = new Intent(Login.this, homepage.class);
                            startActivity(truyenUserPage);

                        } else {
                            Toast.makeText(Login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                        }
                    }}}
        });
        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,ForgotPass.class);
                startActivity(intent);
            }
        });
    }

    private byte[] convertPhoto(int image) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable(image);
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }

    private void prepareDb() {
        if(General.ADB.getCount() == 0) {
            General.ADB.insertData("admin", "admin", "admin", "0123456789", "admin@gmail.com", "20042002", convertPhoto(R.drawable.unknownava));
        }
    }




    private void getData() {
        Intent intentGetData = getIntent();
        edtUsername.setText(intentGetData.getStringExtra("Name_To_Login"));

    }


    private void linkViews() {
        btnLogin = findViewById(R.id.btn_Login);
        btnRegister = findViewById(R.id.btn_Register);
        edtPassword = findViewById(R.id.edt_Password);
        edtUsername = findViewById(R.id.edt_Username);
        txtForgotPass = findViewById(R.id.txt_ForgotPass);
    }
}