package com.example.quanlyluong.GiaoDien.NhanVien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlyluong.R;

import java.util.ArrayList;

public class ThemNhanVien extends AppCompatActivity {
    Button btnLuuNhanVien;
    TextView txtMaNhanVien,txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    RadioButton radNam,radNu;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_PhongBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_nhanvien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        LoadPhongBan();
        adapter_PhongBan = new ArrayAdapter(ThemNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_PhongBan);

        btnLuuNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ThemNhanVien.this,MainNhanVien.class);
                startActivity(intent);
            }
        });
    }
    private void LoadPhongBan()
    {
        data_phongban.add("Nhân Sự");
        data_phongban.add("Tài Chính");
    }
    private void setControl() {
        btnLuuNhanVien = findViewById(R.id.btnLuuNhanVien);
    }
}