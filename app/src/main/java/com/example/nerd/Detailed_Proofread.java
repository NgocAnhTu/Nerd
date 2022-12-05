package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nerd.databinding.ActivityDetailedProofreadBinding;

public class Detailed_Proofread extends AppCompatActivity {

    ActivityDetailedProofreadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detailed_proofread);


        binding = ActivityDetailedProofreadBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvents();

    }

    private void addEvents() {

            binding.imvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Detailed_Proofread.this, Assignments_Nerd.class);
                    startActivity(intent);
                }
            });
        }
    }

