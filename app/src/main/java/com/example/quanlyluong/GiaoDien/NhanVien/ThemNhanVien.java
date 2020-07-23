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

import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class ThemNhanVien extends AppCompatActivity {
    Button btnLuuNhanVien;
    TextView txtMaNhanVien,txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    RadioButton radNam,radNu;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_phongban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_nhanvien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        LoadPhongBan();
        adapter_phongban = new ArrayAdapter(ThemNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_phongban);

        btnLuuNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(txtMaNhanVien.getText().toString());
                nhanVien.setTenNhanVien(txtTenNhanVien.getText().toString());
                nhanVien.setNgaySinh(txtNgaySinh.getText().toString());
                if(radNam.isChecked()==true)
                {
                    nhanVien.setGioiTinh("Nam");
                }
                if(radNu.isChecked()==true)
                {
                     nhanVien.setGioiTinh("Nữ");
                }
                nhanVien.setPhongBan(spPhongBan.getSelectedItem().toString());
                nhanVien.setHeSoLuong(txtHeSoLuong.getText().toString());
                
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
        spPhongBan = findViewById(R.id.spPhongBan);
        txtMaNhanVien = findViewById(R.id.txtMaNhanVien);
        txtTenNhanVien = findViewById(R.id.txtTenNhanVien);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        txtHeSoLuong= findViewById(R.id.txtHeSoLuong);

    }
}