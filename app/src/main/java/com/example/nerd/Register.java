package com.example.nerd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firebase.ReadWriteUserDetails;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Register extends AppCompatActivity {

    ImageView imvback;
    EditText edtEmail, edtName, edtPass, edtRePass, edtPhone, edtDOB;
    Button btnReg;
    CheckBox chkPolicy;
    DatePickerDialog picker;
    private static final String TAG = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        linkView();

        btnReg = findViewById(R.id.btn_Dangky);

        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
                        edtDOB.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, day, month, year);
                picker.show();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textName = edtName.getText().toString();
                String textEmail = edtEmail.getText().toString();
                String textPass = edtPass.getText().toString();
                String textRePass = edtRePass.getText().toString();
                String textPhone = edtPhone.getText().toString();
                String textDOB = edtDOB.getText().toString();

                if(TextUtils.isEmpty(textEmail)) {
                    edtEmail.setError("Vui l??ng nh???p Email");
                    edtName.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    edtEmail.setError("Vui l??ng nh???p Email h???p l???");
                    edtName.requestFocus();
                }else if(TextUtils.isEmpty(textPhone)) {
                    edtPhone.setError("Vui l??ng nh???p s??? ??i???n tho???i");
                    edtName.requestFocus();
                }else if(textPhone.length()!= 10) {
                    edtPhone.setError("S??? ??i???n tho???i bao g???m 10 ch??? s???");
                    edtName.requestFocus();
                }else if(TextUtils.isEmpty(textName)) {
                    edtName.setError("Vui l??ng nh???p t??n");
                    edtName.requestFocus();
                }else if(TextUtils.isEmpty(textPass)) {
                    edtPass.setError("Vui l??ng nh???p m???t kh???u");
                    edtName.requestFocus();
                }else if(TextUtils.isEmpty(textRePass)) {
                    edtRePass.setError("Vui l??ng nh???p l???i m???t kh???u");
                    edtName.requestFocus();
                }else if(!textPass.equals(textRePass)) {
                    edtRePass.setError("M???t kh???u kh??ng tr??ng kh???p");
                    edtName.requestFocus();
                    //xo?? ?? m???t kh???u
                    edtRePass.clearComposingText();
                    edtPass.clearComposingText();
                }else if(TextUtils.isEmpty(textDOB)) {
                    edtDOB.setError("Vui l??ng nh???p ng??y sinh");
                    edtName.requestFocus();
                }else {
                    registerUser(textName, textEmail, textPass, textDOB, textPhone);
                }
            }
        });
        back();

    }

    private void registerUser(String textName, String textEmail, String textPass, String textDOB, String textPhone) {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(textEmail, textPass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textName, textDOB, textPhone);

                    DatabaseReference referenceProfile = FirebaseDatabase
                            .getInstance("https://nerd-app-7a1e1-default-rtdb.asia-southeast1.firebasedatabase.app/")
                            .getReference("Users");

                    referenceProfile.child(firebaseUser.getUid())
                            .setValue(writeUserDetails)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Register.this, "????ng k?? th??nh c??ng. H??y x??c nh???n email ????? ho??n t???t!",
                                        Toast.LENGTH_SHORT).show();

                                //kh??ng cho ng?????i d??ng back ra menu ??ky sau khi dang ky th??nh c??ng

                                Intent intent = new Intent(Register.this, Login.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();

                            }else {
                                Toast.makeText(Register.this, "????ng k?? kh??ng th??nh c??ng.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthUserCollisionException e) {
                        edtEmail.setError("T??i kho???n ???? t???n t???i");
                        edtEmail.requestFocus();
                    }catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                        Toast.makeText(Register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
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

    private void linkView() {
        edtEmail =findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);
        edtName = findViewById(R.id.edt_NameAcc);
        edtPass = findViewById(R.id.edt_Password);
        edtRePass = findViewById(R.id.edt_ReEnterPassword);
        edtDOB = findViewById(R.id.edt_DOB);
        imvback = findViewById(R.id.imv_back);
        chkPolicy = findViewById(R.id.chk_Policy);
    }
}