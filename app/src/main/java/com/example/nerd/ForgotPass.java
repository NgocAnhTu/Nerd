package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.utils.General;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class ForgotPass extends AppCompatActivity {

    EditText edtEmail;
    Button btnRsPass;
    FirebaseAuth authProfile;
    private static final String TAG = "ForgotPass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        linkViews();
        getEvents();
    }

    private void linkViews() {
        edtEmail = findViewById(R.id.edtEmail);
        btnRsPass = findViewById(R.id.btnResetPass);
    }

    private void getEvents() {
        btnRsPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                
                if(TextUtils.isEmpty(email)) {
                    edtEmail.setError("Vui lòng nhập Email");
                    edtEmail.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtEmail.setError("Vui lòng nhập Email hợp lệ");
                    edtEmail.requestFocus();
                }else {
                    resetPassword(email);
                }
            }
        });
    }

    private void resetPassword(String email) {
        authProfile = FirebaseAuth.getInstance();
        authProfile.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ForgotPass.this, "Vui lòng kiểm tra email gửi đến hoặc thư rác",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ForgotPass.this,Login.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                            | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e) {
                        edtEmail.setError("Email chưa được đăng ký");
                        edtEmail.requestFocus();
                    }catch (Exception e) {
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(ForgotPass.this, e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}