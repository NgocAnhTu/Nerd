package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.utils.General;

import java.io.ByteArrayOutputStream;

public class Register extends AppCompatActivity {

    ImageView imvback;
    EditText edtEmail, edtName, edtPass, edtRePass, edtPhone;
    Button btnRegister;
    CheckBox chkPolicy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linkView();
        dangKy();
        back();

    }

    private void back() {
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTranstoPhone = new Intent(Register.this, Login.class);
                startActivity(intentTranstoPhone);
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


    private void dangKy() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check dữ liệu
                String Phone = edtPhone.getText().toString().trim();
                String Email = edtEmail.getText().toString().trim();
                String Name = edtName.getText().toString().trim();
                String Pass = edtPass.getText().toString().trim();
                String RePass = edtRePass.getText().toString().trim();
                if (Email.equals("")
                        ||Phone.equals("") ||Name.equals("")|| Pass.equals("")||RePass.equals("")){
                    Toast.makeText(Register.this, "Vui lòng điền hết các ô!", Toast.LENGTH_SHORT).show();

                }else{
                    if (chkPolicy.isChecked()==false){
                        Toast.makeText(Register.this, "Bạn chưa đồng ý điều khoản!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (General.ADB.checkEmail(Email)||General.ADB.checkPhone(Phone)){
                            Toast.makeText(Register.this, "Email hoặc SĐT đã tồn tại", Toast.LENGTH_SHORT).show();
                        }else {
        if (RePass.equals(Pass)) {
            if (!General.ADB.checkUsername(Name) ) {
                Boolean insert =  General.ADB.insertData(Name, Pass, Name, Phone, Email, "Blank", convertPhoto(R.drawable.unknownava));
                if (insert ) {
                    Intent intentActDangKy = new Intent(Register.this, Login.class);
                    intentActDangKy.putExtra("Name_To_Login", Name);

                    startActivity(intentActDangKy);
                    Toast.makeText(Register.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();

                }
            }else{
                Toast.makeText(Register.this, "Tài khoản đã có sẵn, vui lòng sử dụng tài khoản khác!", Toast.LENGTH_SHORT).show();
            }}else{
            Toast.makeText(Register.this, "Nhập lại mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
        }
    }}
                }
            }
            }
        );
    }

    private void linkView() {
        edtEmail =findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);
        edtName = findViewById(R.id.edt_NameAcc);
        edtPass = findViewById(R.id.edt_Password);
        edtRePass = findViewById(R.id.edt_ReEnterPassword);
        btnRegister = findViewById(R.id.btn_Register);
        imvback = findViewById(R.id.imv_back);
        chkPolicy = findViewById(R.id.chk_Policy);
    }
}