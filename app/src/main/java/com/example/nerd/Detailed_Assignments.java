package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nerd.databinding.ActivityDetailedAssignmentsBinding;

public class Detailed_Assignments extends AppCompatActivity {

    ActivityDetailedAssignmentsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detailed_assignments);


        binding = ActivityDetailedAssignmentsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        addEvents();
    }

    private void addEvents() {

        binding.imvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detailed_Assignments.this, Assignments_Nerd.class);
                startActivity(intent);
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Detailed_Assignments.this);
                dialog.setContentView(R.layout.noti_submit);

                ImageView yes = dialog.findViewById(R.id.imvYes);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Detailed_Assignments.this, "Bài làm của bạn đã được nộp", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

                ImageView Cancle = dialog.findViewById(R.id.imvCancle);
                Cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
    }
}