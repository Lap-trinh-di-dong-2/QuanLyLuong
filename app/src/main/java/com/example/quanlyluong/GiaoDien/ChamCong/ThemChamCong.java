package com.example.quanlyluong.GiaoDien.ChamCong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quanlyluong.DataBase.DBChamCong;
import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.Model.ChamCong;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class ThemChamCong extends AppCompatActivity {
    TextView tvMaNhanVien,tvTenNhanVien;
    EditText txtNgayChamCong,txtSoNgayCong;
    Button btnLuu,btnThoat;
    ArrayList<NhanVien> dataNV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chamcong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        String manv = getIntent().getExtras().getString("ma");
        DBNhanVien dbNhanVien = new DBNhanVien(this);
        dataNV = dbNhanVien.layNhanVienChamCong(manv);
        tvMaNhanVien.setText(dataNV.get(0).getMaNhanVien());
        tvTenNhanVien.setText(dataNV.get(0).getTenNhanVien());
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChamCong chamCong = new ChamCong();
                chamCong.setMaNhanVien(tvMaNhanVien.getText().toString());
                chamCong.setThang(txtNgayChamCong.getText().toString());
                chamCong.setSoNgayCong(txtSoNgayCong.getText().toString());
                DBChamCong dbChamCong =new DBChamCong(getApplicationContext());
                dbChamCong.themChamCong(chamCong);
            }
        });
    }

    private void setControl() {
        tvMaNhanVien =findViewById(R.id.tvMaNhanVien);
        tvTenNhanVien = findViewById(R.id.tvTenNhanVien);
        txtNgayChamCong =findViewById(R.id.txtNgayChamCong);
        txtSoNgayCong = findViewById(R.id.txtSoNgayCong);
        btnLuu = findViewById(R.id.btnLuuChamCong);
        btnThoat= findViewById(R.id.btnThoat);
    }
}