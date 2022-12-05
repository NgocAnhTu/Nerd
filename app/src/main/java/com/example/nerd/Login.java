package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class Login extends AppCompatActivity {
    Button btnLogin, btnReg;
    EditText edtEmail, edtPassword;
    CheckBox ckboxShowHide;
    TextView txtForgotPass;
    FirebaseAuth authProfile;
    private static final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkViews();
        getEvents();

        ckboxShowHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ckboxShowHide.isChecked()) {
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }


    private void getEvents() {
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDangKy = new Intent(Login.this,Register.class);
                startActivity(intentDangKy);
            }
        });

        txtForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgotPass.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                    edtEmail.setError("Yêu cầu nhập email");
                    edtEmail.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("Vui lòng nhập Email hợp lệ");
                    edtEmail.requestFocus();
                }else if(TextUtils.isEmpty(password)) {
                    edtPassword.setError("Vui lòng nhập mật khẩu");
                    edtPassword.requestFocus();
                }else {
                    loginUSer(email, password);
                }
            }
        });
    }

    private void loginUSer(String email, String password) {
        authProfile.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, homepage.class));
                    finish();
                } else  {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e) {
                        edtEmail.setError("Tài khoản không tồn tại");
                        edtEmail.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authProfile.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, homepage.class));
            finish();
        }
    }

    private void linkViews() {
        btnLogin = findViewById(R.id.btn_Login);
        btnReg = findViewById(R.id.btn_Dangky);
        edtPassword = findViewById(R.id.edt_Password);
        edtEmail = findViewById(R.id.edt_Email);
        txtForgotPass = findViewById(R.id.txt_ForgotPass);
        ckboxShowHide = findViewById(R.id.ckbox_show_hide_password);
        authProfile = FirebaseAuth.getInstance();
    }
}