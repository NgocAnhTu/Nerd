package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import com.example.adapters.GVAdapter;
import com.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;


public class GiaoVien extends AppCompatActivity {

    ImageButton ibBack;
    GridView grvToeic, grvIelts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_vien);

        linkView();
        TOEIC();
        IELTS();
        setEvents();

    }

    private void TOEIC() {

        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add( new Teacher( R.drawable.hoa));
        teachers.add( new Teacher( R.drawable.brian));
        teachers.add( new Teacher( R.drawable.zandalee));
        teachers.add( new Teacher( R.drawable.toa));
        teachers.add( new Teacher( R.drawable.andrew));
        teachers.add( new Teacher( R.drawable.warren));

        GVAdapter adapter = new GVAdapter(GiaoVien.this, R.layout.item_teacher, teachers);
        grvToeic.setAdapter(adapter);

    }

    private void IELTS() {

        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add( new Teacher( R.drawable.thanh));
        teachers.add( new Teacher( R.drawable.tung));
        teachers.add( new Teacher( R.drawable.jamin));
        teachers.add( new Teacher( R.drawable.stephen));
        teachers.add( new Teacher( R.drawable.dominic));
        GVAdapter adapter = new GVAdapter(GiaoVien.this, R.layout.item_teacher, teachers);
        grvIelts.setAdapter(adapter);
    }

    private void setEvents() {
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        grvToeic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GiaoVien.this, DetailsGV.class);
                startActivity(intent);
            }
        });
        grvIelts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GiaoVien.this, DetailsGV.class);
                startActivity(intent);
            }
        });
    }

    private void linkView() {
        ibBack = findViewById(R.id.imbBack);
        grvToeic =findViewById(R.id.grv_GV_TOEIC);
        grvIelts = findViewById(R.id.grv_GV_IELTS);
    }
}