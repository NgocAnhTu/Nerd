package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

public class ChangeEmail extends AppCompatActivity {

    TextView txtCurEmail, txtUpdateAuth;
    EditText edtEmailpPdw, edtNewEmail;
    Button btnAuth, btnUpdateEmail;
    String userOldEmail, userNewEmail, userPwd;
    FirebaseAuth authProfile;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        linkViews();

        btnUpdateEmail.setEnabled(false);
        edtNewEmail.setEnabled(false);

        authProfile = FirebaseAuth.getInstance();
        firebaseUser = authProfile.getCurrentUser();

        userOldEmail = firebaseUser.getEmail();
        txtCurEmail.setText(userOldEmail);

        reAuth(firebaseUser);
    }

    private void reAuth(FirebaseUser firebaseUser) {
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPwd = edtEmailpPdw.getText().toString();

                if(TextUtils.isEmpty(userPwd)) {
                    edtEmailpPdw.setError("Vui lòng nhập mật khẩu");
                    edtEmailpPdw.requestFocus();
                }else {
                    AuthCredential credential = EmailAuthProvider.getCredential(userOldEmail, userPwd);

                    firebaseUser.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            txtUpdateAuth.setText("Bạn đã có thể update Email");

                            edtNewEmail.setEnabled(true);
                            edtEmailpPdw.setEnabled(false);

                            btnAuth.setEnabled(false);
                            btnUpdateEmail.setEnabled(true);

                            btnUpdateEmail.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    userNewEmail = edtNewEmail.getText().toString();

                                    if(TextUtils.isEmpty(userNewEmail)) {
                                        edtNewEmail.setError("Bạn chưa nhập Email mới");
                                        edtNewEmail.requestFocus();
                                    }else if(!Patterns.EMAIL_ADDRESS.matcher(userNewEmail).matches()) {
                                        edtNewEmail.setError("Vui lòng nhập Email hợp lệ");
                                        edtNewEmail.requestFocus();
                                    }else if(userOldEmail.matches(userNewEmail)) {
                                        edtNewEmail.setError("Bạn đã nhập Email cũ, vui lòng nhập Email mới");
                                        edtNewEmail.requestFocus();
                                    }else {
                                        updateEmail(firebaseUser);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    private void updateEmail(FirebaseUser firebaseUser) {
        firebaseUser.updateEmail(userNewEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    firebaseUser.sendEmailVerification();

                    Toast.makeText(ChangeEmail.this, "Email đã được cập nhật, vui lòng kiểm tra và ấn link xác nhận",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ChangeEmail.this,Setting.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void linkViews() {
        txtCurEmail = findViewById(R.id.txtCurrentEmail);
        txtUpdateAuth = findViewById(R.id.txt_update_email_authenticated);
        edtEmailpPdw = findViewById(R.id.edtEmailPwd);
        edtNewEmail = findViewById(R.id.edt_update_email_new);
        btnAuth = findViewById(R.id.btn_Auth);
        btnUpdateEmail = findViewById(R.id.btn_update_email);
    }
}