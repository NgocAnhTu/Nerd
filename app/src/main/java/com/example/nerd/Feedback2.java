package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback2 extends AppCompatActivity {
        Button btnGui;
        EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);

        btnGui = findViewById(R.id.btn_guiykien);
        edt1 = findViewById(R.id.edt_Feedback1);
        edt2 = findViewById(R.id.edt_Feedback2);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt1.setText("");
                edt2.setText("");
                Toast.makeText(Feedback2.this, "Ý kiến của bạn đã được nộp", Toast.LENGTH_SHORT).show();
            }
        });
    }
}