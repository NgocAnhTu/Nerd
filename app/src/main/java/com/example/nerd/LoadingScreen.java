package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class LoadingScreen extends AppCompatActivity {

    private static int LOADING = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading_screen);

        new Handler().postDelayed((Runnable) () -> {
            Intent intent;
            intent = new Intent(LoadingScreen.this, Login.class);
            startActivity(intent);
            finish();
        },LOADING);
    }
}