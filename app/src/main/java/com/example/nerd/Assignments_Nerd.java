package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.example.nerd.databinding.ActivityAssignmentsNerdBinding;

import java.util.ArrayList;

public class Assignments_Nerd extends AppCompatActivity {

    ActivityAssignmentsNerdBinding binding;

    TabHost tabHost;
    ArrayList<String> assignments_list;
    Button btnDaSua, btnDangDoiSua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityAssignmentsNerdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addControl();
        addEvents();
        linkView();

        btnDaSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaSua.setTextColor(Color.WHITE);
                btnDaSua.setBackgroundResource(R.drawable.border);
                btnDangDoiSua.setTextColor(Color.BLACK);
                btnDangDoiSua.setBackgroundResource(R.drawable.khung_border);
            }
        });

        btnDangDoiSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDangDoiSua.setTextColor(Color.BLACK);
                btnDangDoiSua.setBackgroundResource(R.drawable.border);
                btnDaSua.setTextColor(Color.WHITE);
                btnDaSua.setBackgroundResource(R.drawable.khung_border);
            }
        });
    }

    private void linkView() {
        btnDaSua = findViewById(R.id.btn_DaSua);
        btnDangDoiSua = findViewById(R.id.btn_DangDoiSua);


    }


    private void addEvents() {

        binding.imbtnProofread1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assignments_Nerd.this, Detailed_Proofread.class);
                startActivity(intent);
            }
        });

        binding.imbtnBaiTap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assignments_Nerd.this, Detailed_Assignments.class);
                startActivity(intent);
            }
        });
    }



    private void addControl() {

        assignments_list = new ArrayList<>();
//        adapter = new ArrayAdapter<>(Assignments_Nerd.this, android.R.layout.simple_list_item_1, assignments_list);
//        lv.setAdapter(adapter);

        tabHost = findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1, spec2;

        spec1 = tabHost.newTabSpec("Assignments");
        spec1.setContent(R.id.Assignments);
        spec1.setIndicator("Assignments");
        tabHost.addTab(spec1);

        spec2 = tabHost.newTabSpec("Proofread");
        spec2.setContent(R.id.Proofread);
        spec2.setIndicator("Proofread");
        tabHost.addTab(spec2);

    }

}