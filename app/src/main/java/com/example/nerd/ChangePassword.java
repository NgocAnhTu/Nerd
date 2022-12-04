package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    TextView txtAuth;
    EditText edtOldPwd, edtNewPwd, edtReNewPwd;
    Button btnAuth, btnUpdate;
    String userCurrPwd, userNewPwd, userNewPwdConfirm;
    FirebaseAuth authProfile;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        linkViews();

        edtNewPwd.setEnabled(false);
        edtReNewPwd.setEnabled(false);
        btnUpdate.setEnabled(false);

        authProfile = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = authProfile.getCurrentUser();

        reAuth(firebaseUser);
    }

    private void reAuth(FirebaseUser firebaseUser) {
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCurrPwd = edtOldPwd.getText().toString();

                if(TextUtils.isEmpty(userCurrPwd)) {
                    edtOldPwd.setError("Vui lòng nhập mật khẩu");
                    edtOldPwd.requestFocus();
                } else {
                    AuthCredential credential = EmailAuthProvider.getCredential(firebaseUser.getEmail(), userCurrPwd);

                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            txtAuth.setText("Bạn đã có thể đổi mật khẩu");

                            edtNewPwd.setEnabled(true);
                            edtReNewPwd.setEnabled(true);
                            edtOldPwd.setEnabled(false);

                            btnUpdate.setEnabled(true);
                            btnAuth.setEnabled(false);

                            btnUpdate.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    changePwd(firebaseUser);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void changePwd(FirebaseUser firebaseUser) {
        userNewPwd = edtNewPwd.getText().toString();
        userNewPwdConfirm = edtReNewPwd.getText().toString();

        if(TextUtils.isEmpty(userNewPwd)) {
            edtNewPwd.setError("Vui lòng nhập mật khẩu mới");
            edtNewPwd.requestFocus();
        }else if(TextUtils.isEmpty(userNewPwdConfirm)) {
            edtReNewPwd.setError("Vui lòng nhập lại mật khẩu mới");
            edtReNewPwd.requestFocus();
        }else if(!userNewPwd.matches(userNewPwdConfirm)) {
            edtReNewPwd.setError("Mật khẩu không khớp");
            edtReNewPwd.requestFocus();
        }else if(userCurrPwd.matches(userNewPwd)) {
            edtNewPwd.setError("Bạn đã nhập mật khẩu cũ");
            edtNewPwd.requestFocus();
        }else {
            firebaseUser.updatePassword(userNewPwd).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(ChangePassword.this, "Đổi mật khẩu thành công",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ChangePassword.this, Setting.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private void linkViews() {
        txtAuth = findViewById(R.id.txt_update_pwd_authenticated);
        edtOldPwd = findViewById(R.id.edtOldPwd);
        edtNewPwd = findViewById(R.id.edt_update_pwd_new);
        edtReNewPwd = findViewById(R.id.edt_re_pwd_new);
        btnAuth = findViewById(R.id.btn_Auth_Pwd);
        btnUpdate = findViewById(R.id.btn_update_pwd);
    }
}