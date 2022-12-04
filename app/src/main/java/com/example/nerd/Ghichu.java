package com.example.nerd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapters.NoteAdapter;
import com.example.database.NoteDatabase;
import com.example.model.Note;

import java.util.ArrayList;

public class Ghichu extends AppCompatActivity {
    NoteDatabase database;
    ListView lvCongViec;
    ArrayList<Note> arrayCongViec;
    NoteAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichu);

        lvCongViec = findViewById(R.id.lv_Note);
        arrayCongViec = new ArrayList<>();
        adapter = new NoteAdapter(this,R.layout.item_note,arrayCongViec);
        lvCongViec.setAdapter(adapter);

        // tạo database
        database = new NoteDatabase(this,"todolist.sqlite",null,1);
        // tạo bảng
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR(200))");
        // insert data
//        database.QueryData("INSERT INTO CongViec VALUES(null,'Thi')");
        GetDataCongViec();

    }

    private void GetDataCongViec(){
        // select data
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        arrayCongViec.clear();
        while (dataCongViec.moveToNext()){
            int id = dataCongViec.getInt(0);
            String tenCV = dataCongViec.getString(1);
            arrayCongViec.add(new Note(id, tenCV));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.them_ghichu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuThemCV){
            DialogThemCV();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogThemCV(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_themghichu);

        final EditText edtTenCV = dialog.findViewById(R.id.edtTenCV);
        Button btnThem = dialog.findViewById(R.id.btnThem);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCV = edtTenCV.getText().toString();
                if(tenCV.equals("")){
                    Toast.makeText(Ghichu.this,"Bạn chưa nhập tên công việc", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.QueryData("INSERT INTO CongViec VALUES(null,'"+ tenCV +"')");
                    Toast.makeText(Ghichu.this,"Thêm thành công "+ tenCV, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    GetDataCongViec();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void DialogSuaCV(String tenCV, final int id){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_suaghichu);

        final EditText edtSuaCV = dialog.findViewById(R.id.edtSuaTenCV);
        Button btnLuu = dialog.findViewById(R.id.btnLuu);
        Button btnHuy = dialog.findViewById(R.id.btnHuySua);

        edtSuaCV.setText(tenCV);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCVMoi = edtSuaCV.getText().toString();
                database.QueryData("UPDATE CongViec SET TenCV = '"+ tenCVMoi +"' WHERE Id = '"+ id +"'" );
                Toast.makeText(Ghichu.this,"Sửa thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                GetDataCongViec();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void XoaCV(String tenCV, int id){
        database.QueryData("DELETE FROM CongViec WHERE Id = '"+ id +"'");
        Toast.makeText(Ghichu.this,"Bạn đã xóa " + tenCV,Toast.LENGTH_SHORT).show();
        GetDataCongViec();
    }
}
