package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.ItemBuoiHocAdapter;
import com.example.adapters.ItemLopHocSapDienRaAdapter;
import com.example.model.Lichsulophoc;
import com.example.model.Lophocsapdienra;

import java.util.ArrayList;

public class lichhoc extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<Lichsulophoc> lichsulophocs;
    ItemBuoiHocAdapter itemBuoiHocAdapter;
    ListView lvHienThiLopHoc;
    Button btnLichSuLopHoc, btnLopHocSapDienRa;
    ArrayList<Lophocsapdienra> lopHocSapDienRas;
    ItemLopHocSapDienRaAdapter itemLopHocSapDienRaAdapter;
    TextView txtNgay;
    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichhoc);

        linkview();
        loadDataLichsulophoc();

        btnLichSuLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDataLichsulophoc();
                btnLichSuLopHoc.setTextColor(Color.WHITE);
                btnLichSuLopHoc.setBackgroundResource(R.drawable.khung_border_picked);
                btnLopHocSapDienRa.setTextColor(Color.BLACK);
                btnLopHocSapDienRa.setBackgroundResource(R.drawable.khung_border);
            }
        });

        btnLopHocSapDienRa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDataLopHocSapDienRa();
                btnLichSuLopHoc.setTextColor(Color.BLACK);
                btnLichSuLopHoc.setBackgroundResource(R.drawable.khung_border);
                btnLopHocSapDienRa.setTextColor(Color.WHITE);
                btnLopHocSapDienRa.setBackgroundResource(R.drawable.khung_border_picked);
            }
        });
    }

    private void loadDataLopHocSapDienRa() {
        lopHocSapDienRas = new ArrayList<>();
        lopHocSapDienRas.add(new Lophocsapdienra("Topic: Animal", "9:00", "26/12/2022", "Thầy Trần Tùng", "11/16 người" ));
        lopHocSapDienRas.add(new Lophocsapdienra("Study 1:1: How to introduce my hometown", "12:00", "15/12/2022", "Cô Tường Thanh", "1/1 người" ));
        lopHocSapDienRas.add(new Lophocsapdienra("Topic: Travel", "16:00", "26/1/2023", "Thầy Trần Tùng", "05/16 người" ));
        lopHocSapDienRas.add(new Lophocsapdienra("Study 1:1: School", "16:00", "22/12/2022", "Ms Hoa TOEIC", "1/1 người"));
        lopHocSapDienRas.add(new Lophocsapdienra("Study 1:1: Technology", "12:00", "25/12/2022", "Ms Hoa TOEIC", "1/1 người" ));
        itemLopHocSapDienRaAdapter = new ItemLopHocSapDienRaAdapter(this, lopHocSapDienRas);
        lvHienThiLopHoc.setAdapter(itemLopHocSapDienRaAdapter);
        lvHienThiLopHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(lichhoc.this, ThoiKhoaBieu.class);
                startActivity(intent);
            }
        });
    }

    private void loadDataLichsulophoc() {
        lichsulophocs = new ArrayList<>();
        lichsulophocs.add(new Lichsulophoc("Study 1:1: How to introduce yourself", "12:00", "22/12/2021", "Cô Tường Thanh" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Home and family", "9:00", "17/12/2021", "Thầy Trần Tùng" ));
        lichsulophocs.add(new Lichsulophoc("Topic: Education", "16:00", "10/12/2021", "Thầy Trần Tùng" ));
        lichsulophocs.add(new Lichsulophoc("Study 1:1: Country", "9:00", "24/12/2021", "Ms Hoa TOEIC" ));
        lichsulophocs.add(new Lichsulophoc("Study 1:1: History", "12:00", "6/12/2021", "Ms Hoa TOEIC" ));
        itemBuoiHocAdapter = new ItemBuoiHocAdapter(this, lichsulophocs);
        lvHienThiLopHoc.setAdapter(itemBuoiHocAdapter);
        lvHienThiLopHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(lichhoc.this, LichSuLopHojc.class);
                startActivity(intent);
            }
        });
    }

    private void linkview() {
        lvHienThiLopHoc = findViewById(R.id.lvHienThiLopHoc);
        btnLichSuLopHoc = findViewById(R.id.btnLichsulophoc);
        btnLopHocSapDienRa = findViewById(R.id.btnLophocsapdienra);
        txtNgay = findViewById(R.id.txtNgay);
        imbBack = findViewById(R.id.imbBack);

        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}