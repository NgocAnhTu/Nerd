package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.utils.General;

public class ForgotPass extends AppCompatActivity {

    EditText edtPass, edtNewPass,edtReEnter;
    Button btnUpdate;
    ImageView imvBack;
    String username = General.Us.getUsername();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        linkViews();
        getEvents();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imv_back);
        edtPass = findViewById(R.id.edtCurrentPass);
        edtNewPass = findViewById(R.id.edtNewPass);
        edtReEnter = findViewById(R.id.edt_ReEnterPassword);
        btnUpdate = findViewById(R.id.btnUpdatePass);
    }

    private void getEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String PresentPass = edtPass.getText().toString().trim();
                String newPass = edtNewPass.getText().toString().trim();
                String newRePass = edtReEnter.getText().toString().trim();
                if (PresentPass.equals("")||newPass.equals("")||newRePass.equals("")){
                    Toast.makeText(ForgotPass.this, "Vui lòng điền hết các ô!", Toast.LENGTH_SHORT).show();
                }else {
                    if (!General.ADB.checkUsernamePassword(username,PresentPass)){
                        Toast.makeText(ForgotPass.this, "Mật khẩu hiện tại không đúng! ", Toast.LENGTH_SHORT).show();
                    }else {
                        if (newPass.equals(PresentPass)) {
                            Toast.makeText(ForgotPass.this, "Mật khẩu mới trùng mật khẩu cũ!", Toast.LENGTH_SHORT).show();
                        } else {
                            if (!newPass.equals(newRePass)) {
                                Toast.makeText(ForgotPass.this, "Nhập lại mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                            } else {
                                General.ADB.updatePass( username,newPass);
                                Toast.makeText(ForgotPass.this, "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    }}}
        });
    }
}