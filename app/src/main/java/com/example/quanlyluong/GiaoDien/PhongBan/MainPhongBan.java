package com.example.quanlyluong.GiaoDien.PhongBan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.Adapter.CustomAdapterPhongBan;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

public class MainPhongBan extends AppCompatActivity {
    EditText txtMaPhong, txtTenPhong;
    Button btnThem;
    ListView lvDanhSach;
    boolean ngonNgu = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phongban);
        setControl();
        setEvent();
    }

    private void setEvent() {
        Load();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhongBan phongBan = new PhongBan();
                phongBan.setMaPhong(txtMaPhong.getText().toString());
                phongBan.setTenPhong(txtTenPhong.getText().toString());
                DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
                dbPhongBan.themPhongBan(phongBan);
                Toast.makeText(MainPhongBan.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                Load();
            }
        });
    }

    private void Load() {
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        CustomAdapterPhongBan adapter = new CustomAdapterPhongBan(MainPhongBan.this, R.layout.listview_phongban, dbPhongBan.layDuLieu());
        lvDanhSach.setAdapter(adapter);
    }

    private void setControl() {
        txtMaPhong = findViewById(R.id.txtMaPhong);
        txtTenPhong = findViewById(R.id.txtTenPhong);
        btnThem = findViewById(R.id.btnThem);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }
}
